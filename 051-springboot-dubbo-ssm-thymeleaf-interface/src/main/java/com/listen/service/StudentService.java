package com.listen.service;

import com.listen.domain.Student;

import java.util.List;

/**
 * @Author: Listen
 * @Date: 2020/7/23
 */
public interface StudentService {
    Integer queryAllStudentCount();

    Student queryStudentById(Integer id);

    List<Student> queryAllStudents();

    int addStudent(Student student);

    int editStudentById(Student student);

    int deleteStudentById(Integer id);
}
