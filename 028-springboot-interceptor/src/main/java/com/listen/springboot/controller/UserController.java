package com.listen.springboot.controller;

import com.listen.springboot.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Listen
 * @Date: 2020/7/21
 */
@Controller
public class UserController {

    //该方法用户不登录也可以访问
    @ResponseBody
    @RequestMapping("/index")
    public Object index(){
        return "Index Page";
    }

    //该方法用户不登录也可以访问
    @ResponseBody
    @RequestMapping("/user/page/login")
    public Object pageLogin(){
        return "Login Page";
    }

    //该方法用户不登录也可以访问，访问过后，用户处于登录状态
    @ResponseBody
    @RequestMapping("/user/login")
    public Object login(HttpServletRequest request){
        User user = new User(1,"猴子");
        request.getSession().setAttribute("user", user);
        return "User Logged";
    }

    //该方法需要用户登录之后才可以访问
    @ResponseBody
    @RequestMapping("/user/center")
    public Object userCenter(){
        return "User Center";
    }



}
