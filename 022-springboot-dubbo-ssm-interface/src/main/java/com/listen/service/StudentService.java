package com.listen.service;

import com.listen.domain.Student;

/**
 * @Author: Listen
 * @Date: 2020/7/21
 */
public interface StudentService {
    /**
     * 获取学生总人数
     * @return
     */
    Integer queryAllStudentCount();


    /**
     * 根据学生标识获取学生详情
     * @param id
     * @return
     */
    Student queryStudentById(Integer id);
}
