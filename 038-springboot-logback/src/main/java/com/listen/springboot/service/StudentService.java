package com.listen.springboot.service;

import com.listen.springboot.domain.Student;

/**
 * @Author: Listen
 * @Date: 2020/7/22
 */
public interface StudentService {
    Student queryStudentById(Integer id);
}
