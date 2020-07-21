package com.listen.springboot.service.impl;

import com.listen.springboot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: Listen
 * @Date: 2020/7/21
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello() {
        return "Say：Hello SpringBoot Java Project";
    }
}
