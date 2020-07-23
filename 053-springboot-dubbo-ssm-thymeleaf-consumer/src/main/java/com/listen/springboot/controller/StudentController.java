package com.listen.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.listen.domain.Student;
import com.listen.service.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Listen
 * @Date: 2020/7/23
 */
@Controller
public class StudentController {
    @Reference(interfaceClass = StudentService.class, version = "1.0.0", check = false)
    private StudentService studentService;
    final Integer[] allStudentCount = new Integer[1];

    @RequestMapping("/student/count")
    public String studentCount(Model model) {
        ExecutorService service = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 1000; i++) {
            service.submit(() -> allStudentCount[0] = studentService.queryAllStudentCount());
        }
        service.shutdown();
        model.addAttribute("allStudentCount", allStudentCount[0]);
        return "studentCount";
    }

    @GetMapping("/student/list")
    public String studentDetail(Model model) {
        Integer allStudentCount = studentService.queryAllStudentCount();
        List<Student> studentList = studentService.queryAllStudents();
        model.addAttribute("allStudentCount", allStudentCount);
        model.addAttribute("studentList", studentList);
        return "list";
    }

    @RequestMapping("/student/toAdd")
    public String toAddStudent(){
        return "addStudent";
    }

    @PostMapping("/student/add/{userName}/{userAge}")
    public String addStudent(@PathVariable("userName") String userName,@PathVariable("userAge") Integer userAge){
        Student student = new Student();
        student.setUserName(userName);
        student.setUserAge(userAge);
        int result = studentService.addStudent(student);
        return "redirect:/student/list";
    }


    @GetMapping("/student/toEdit/{id}")
    public String toEditStudent(@PathVariable Integer id,Model model){
        Student student = studentService.queryStudentById(id);
        model.addAttribute("student",student);
        return "editStudent";
    }

    @PutMapping("/student/edit/{id}/{userName}/{userAge}")
    public String editStudent(@PathVariable("id") Integer id,
                              @PathVariable("userName") String userName,
                              @PathVariable("userAge") Integer userAge){
        int result = studentService.editStudentById(new Student(id,userName,userAge));
        return "redirect:/student/list";
    }

    @ResponseBody
    @DeleteMapping("/student/delete/{id}")
    public Integer editStudent(@PathVariable Integer id,Model model){
        int result = studentService.deleteStudentById(id);
        return result;
    }
}
