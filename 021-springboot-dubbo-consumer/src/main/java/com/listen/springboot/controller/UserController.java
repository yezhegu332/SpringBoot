package com.listen.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.listen.domain.User;
import com.listen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Listen
 * @Date: 2020/7/21
 */
@RestController
public class UserController {
    @Reference(interfaceClass = UserService.class,version = "1.0.0",check = false)
    private UserService userService;

    @RequestMapping("/user/count")
    public Object userCount(){
        Integer allUserCount = userService.queryAllUserCount();
        return "总人数为："+allUserCount;
    }

    @RequestMapping("/user/detail/{id}")
    public Object userCount(@PathVariable Integer id){
        User user = userService.queryUserById(id);
        return user;
    }
}
