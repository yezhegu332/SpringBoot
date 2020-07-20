package com.listen.springboot.controller;

import com.listen.springboot.domain.Student;
import com.listen.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Listen
 * @Date: 2020/7/20
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("student/detail")
    public Object detail(Integer id){
        Student student = studentService.queryStudentById(id);
        return student;
    }
}
