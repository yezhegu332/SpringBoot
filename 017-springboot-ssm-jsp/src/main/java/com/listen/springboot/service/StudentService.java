package com.listen.springboot.service;

import com.listen.springboot.domain.Student;

import java.util.List;

/**
 * @Author: Listen
 * @Date: 2020/7/20
 */
public interface StudentService {
    Student queryStudentById(Integer id);

    int addStudent(Student student);

    int modifyStudent(Student student);

    int deleteStudent(Integer id);

    List<Student> queryAllStudent();
}
