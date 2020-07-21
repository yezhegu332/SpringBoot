package com.listen.springboot.controller;

import com.listen.springboot.domain.Student;
import com.listen.springboot.service.StudentService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Listen
 * @Date: 2020/7/20
 */

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student")
    public String toDetail(Model model) {
        List<Student> studentList = studentService.queryAllStudent();
        model.addAttribute("studentList", studentList);
        return "studentDetail";
    }

    //查询学生并赋值修改页面
    @GetMapping("/student/detail/{id}")
    public String studentGet(Model model, @PathVariable("id") Integer id) {
        Student student = studentService.queryStudentById(id);
        model.addAttribute("student", student);
        return "editStudent";
    }

    //新增学生
    @PostMapping("/student/detail/{userName}/{userAge}")
    public String studentPost(@PathVariable("userName") String userName, @PathVariable("userAge") Integer userAge) {
        Student student = new Student();
        student.setUserName(userName);
        student.setUserAge(userAge);
        studentService.addStudent(student);
        return "redirect:/student";
    }

    //修改学生信息
    @PutMapping(value = "/student/detail/{id}/{userName}/{userAge}")
    public String studentPut(@PathVariable("id") Integer id, @PathVariable("userName") String userName, @PathVariable("userAge") Integer userAge) {
        Student student = new Student(id, userName, userAge);
        studentService.modifyStudent(student);
        return "redirect:/student";
    }

    //删除指定学生
    @DeleteMapping(value = "/student/detail/{id}")
    public String studentDelete(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/student";
    }
}
