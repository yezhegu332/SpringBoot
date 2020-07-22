package com.listen.springboot.service.impl;

import com.listen.springboot.domain.Student;
import com.listen.springboot.mapper.StudentMapper;
import com.listen.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Listen
 * @Date: 2020/7/22
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
