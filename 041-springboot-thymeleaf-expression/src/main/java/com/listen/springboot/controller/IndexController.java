package com.listen.springboot.controller;

import com.listen.springboot.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Listen
 * @Date: 2020/7/22
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("data", "步摇碧莲123");
        return "index";
    }

    @RequestMapping("/user/detail")
    public String userDetail(Model model){
        User user = new User();
        user.setId(1001);
        user.setUserName("孙悟空");
        model.addAttribute("data", "标准变量表达式");
        model.addAttribute("user", user);
        return "userDetail";
    }

    @RequestMapping("/url")
    public String url(Model model){
        model.addAttribute("userId", 1005);
        model.addAttribute("username", "王老板");
        return "url";
    }

    @RequestMapping("/user/info")
    public String userInfo(Model model,Integer id,String username){
        model.addAttribute("id", id);
        model.addAttribute("username", username);
        return "userInfo";
    }
}
