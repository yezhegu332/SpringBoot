package com.listen.springboot.controller;

import com.listen.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Listen
 * @Date: 2020/7/21
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    final Integer[] AllStudentCont = new Integer[1];

    @ResponseBody
    @RequestMapping("/student/count")
    public Object studentCount() {
        //创建一个固定的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 500; i++) {
            //开启一个线程
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.submit(() -> {
                AllStudentCont[0] = studentService.queryAllStudentCount();
            });
        }
        executorService.shutdown();
        System.out.println("---------------线程池销毁了------------------");

        return "AllStudentCount = " + AllStudentCont[0];
    }
}
