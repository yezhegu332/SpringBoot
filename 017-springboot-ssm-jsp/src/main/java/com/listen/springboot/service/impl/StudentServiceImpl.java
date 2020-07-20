package com.listen.springboot.service.impl;

import com.listen.springboot.domain.Student;
import com.listen.springboot.mapper.StudentMapper;
import com.listen.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Listen
 * @Date: 2020/7/20
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.insertSelective(student);
    }

    @Override
    public int modifyStudent(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public int deleteStudent(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Student> queryAllStudent() {
        return studentMapper.selectAllStudent();
    }

}
