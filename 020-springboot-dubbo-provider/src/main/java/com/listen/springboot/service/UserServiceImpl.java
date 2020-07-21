package com.listen.springboot.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.listen.domain.User;
import com.listen.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @Author: Listen
 * @Date: 2020/7/21
 */
//@Service 相当于 dubbo:service class="" version="" ref="" timeout=""
@Component
@Service(interfaceClass = UserService.class, version = "1.0.0", timeout = 15000)
public class UserServiceImpl implements UserService {
    @Override
    public Integer queryAllUserCount() {
        //调用数据持久层
        return 10;
    }

    @Override
    public User queryUserById(Integer id) {
        //调用数据持久层
        User user = new User(id, "猴子");
        return user;
    }
}
