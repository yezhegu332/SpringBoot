package com.listen.springboot.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.listen.domain.Student;
import com.listen.service.StudentService;
import com.listen.springboot.mapper.StudentMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Listen
 * @Date: 2020/7/21
 */

@Component
@Service(interfaceClass = StudentService.class, version = "1.0.0")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public Integer queryAllStudentCount() {
        Integer allStudentCount = (Integer) redisTemplate.opsForValue().get("allStudentCount");
        if (!ObjectUtils.allNotNull(allStudentCount)) {
            synchronized (StudentServiceImpl.class) {
                allStudentCount = (Integer) redisTemplate.opsForValue().get("allStudentCount");
                if (!ObjectUtils.allNotNull(allStudentCount)) {
                    allStudentCount = studentMapper.selectAllCountOfStudents();
                    redisTemplate.opsForValue().set("allStudentCount", allStudentCount, 100, TimeUnit.MILLISECONDS);
                    System.out.println(Thread.currentThread().getName() + "：在数据库中重新获取：" + allStudentCount);
                }
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "：在redis中拿到：" + allStudentCount);
        }
        return allStudentCount;
    }

    @Override
    public Student queryStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
