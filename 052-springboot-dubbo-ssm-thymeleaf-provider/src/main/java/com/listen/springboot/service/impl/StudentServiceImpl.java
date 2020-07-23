package com.listen.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.listen.domain.Student;
import com.listen.service.StudentService;
import com.listen.springboot.mapper.StudentMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Listen
 * @Date: 2020/7/23
 */
@Component
@Service(interfaceClass = StudentService.class, version = "1.0.0", timeout = 15000)
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    //    private AtomicInteger threadCount;
    private volatile int threadCount = 0;


    @Override
    public Integer queryAllStudentCount() {
        String threadName = "";
        Integer allStudentCount = (Integer) redisTemplate.opsForValue().get("allStudentCount");
        if (allStudentCount == null) {
            synchronized (this) {
                allStudentCount = (Integer) redisTemplate.opsForValue().get("allStudentCount");
                if (allStudentCount == null) {
                    allStudentCount = studentMapper.selectAllStudentCount();
                    redisTemplate.opsForValue().set("allStudentCount", allStudentCount, 20, TimeUnit.MILLISECONDS);
                    threadName = Thread.currentThread().getName();
                    System.out.println(threadName + "重新从数据库中查询：" + allStudentCount + "；线程数：" + (++threadCount));
                } else {
                    allStudentCount = (Integer) redisTemplate.opsForValue().get("allStudentCount");
                }
            }
        }
        //要输出完整的线程数，下面的if只需加synchronized即可
        if (!Thread.currentThread().getName().equals(threadName)) {
            System.out.println(Thread.currentThread().getName() + "从redis中查询：" + allStudentCount + "；线程数：" + (++threadCount));
        }
        return allStudentCount;
    }

    @Override
    @Transactional(readOnly = true)
    public Student queryStudentById(Integer id) {
        Student student = (Student) redisTemplate.opsForValue().get(id);
        if (student == null) {
            synchronized (this) {
                if (student == null) {
                    student = studentMapper.selectByPrimaryKey(id);
                    if (student == null) {
                        return new Student();
                    }
                    redisTemplate.opsForValue().set(id, student);
                } else {
                    student = (Student) redisTemplate.opsForValue().get(id);
                }
            }
        }
        return student;

    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> queryAllStudents() {
        return studentMapper.selectAllStudents();
    }

    @Override
    @Transactional
    public int addStudent(Student student) {
        return studentMapper.insertSelective(student);
    }

    @Override
    public int editStudentById(Student student) {
        return studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public int deleteStudentById(Integer id) {
        redisTemplate.delete(id);
        return studentMapper.deleteByPrimaryKey(id);
    }
}
