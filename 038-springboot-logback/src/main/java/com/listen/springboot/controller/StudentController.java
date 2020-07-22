package com.listen.springboot.controller;

import com.listen.springboot.domain.Student;
import com.listen.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Listen
 * @Date: 2020/7/22
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("/student/detail/{id}")
    public Object studentDetail(@PathVariable("id") Integer id){
        Student student = studentService.queryStudentById(id);
        return student;
    }
}
