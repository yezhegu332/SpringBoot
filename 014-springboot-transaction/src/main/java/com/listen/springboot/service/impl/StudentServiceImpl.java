package com.listen.springboot.service.impl;

import com.listen.springboot.domain.Student;
import com.listen.springboot.mapper.StudentMapper;
import com.listen.springboot.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: Listen
 * @Date: 2020/7/20
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

   @Transactional
    @Override
    public int modifyStudentById(Student student) {
        int result = studentMapper.updateByPrimaryKeySelective(student);
        int i = 10/0;   //此处异常，事务回滚
        return result;
    }
}
