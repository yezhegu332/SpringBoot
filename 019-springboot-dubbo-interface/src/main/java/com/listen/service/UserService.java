package com.listen.service;

import com.listen.domain.User;

/**
 * @Author: Listen
 * @Date: 2020/7/21
 */
public interface UserService {
    /**
     * 获取用户总人数
     * @return
     */
    Integer queryAllUserCount();

    /**
     * 根据用户标识获取用户详情
     * @param id
     * @return
     */
    User queryUserById(Integer id);
}
