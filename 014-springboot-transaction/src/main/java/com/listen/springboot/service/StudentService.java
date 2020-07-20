package com.listen.springboot.service;

import com.listen.springboot.domain.Student;

/**
 * @Author: Listen
 * @Date: 2020/7/20
 */
public interface StudentService {
    /*
    * 根据学生标识获取学生详情
    */
    Student queryStudentById(Integer id);

    int modifyStudentById(Student student);
}
