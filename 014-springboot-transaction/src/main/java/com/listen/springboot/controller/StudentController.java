package com.listen.springboot.controller;

import com.listen.springboot.domain.Student;
import com.listen.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Listen
 * @Date: 2020/7/20
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("/student/detail")
    public Object studentDetail(Integer id){
        return studentService.queryStudentById(id);
    }

    @ResponseBody
    @RequestMapping("/student/update")
    public Object studentDetail(Integer id,String userName,Integer userAge){
        Student student = new Student();
        student.setId(id);
        student.setUserName(userName);
        student.setUserAge(userAge);
        return studentService.modifyStudentById(student);
    }
}
