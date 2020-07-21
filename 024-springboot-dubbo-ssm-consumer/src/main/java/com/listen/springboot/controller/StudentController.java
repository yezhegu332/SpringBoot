package com.listen.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.listen.domain.Student;
import com.listen.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Listen
 * @Date: 2020/7/21
 */
@Controller
public class StudentController {
    @Reference(interfaceClass = StudentService.class, version = "1.0.0", check = false)
    private StudentService studentService;
    final private Integer[] studentCount = new Integer[1];

    @ResponseBody
    @RequestMapping("/student/count")
    public Object userCount() {
        ExecutorService service = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 100; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            service.submit(() -> studentCount[0] = studentService.queryAllStudentCount());
        }

        service.shutdown();
        System.out.println("线程池关闭");
        studentCount[0] = studentService.queryAllStudentCount();
        return "学生总人数为：" + studentCount[0];
    }

    @RequestMapping("/student/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Student student = studentService.queryStudentById(id);
        model.addAttribute("student", student);
        return "student/detail";
    }
}
