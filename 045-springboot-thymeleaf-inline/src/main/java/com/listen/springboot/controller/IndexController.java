package com.listen.springboot.controller;

import com.listen.springboot.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Listen
 * @Date: 2020/7/23
 */
@Controller
public class IndexController {
    @RequestMapping("/user/info")
    public String userInfo(Model model){
        User user =  new User();
        user.setId(1001);
        user.setName("孙悟空");
        user.setPhone(130000000);
        model.addAttribute("user", user);
        return "user/userInfo";
    }
}
