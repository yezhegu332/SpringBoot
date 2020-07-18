package com.listen.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 李松
 * 2020/7/18
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("data", "SpringBoot JSP页面");
        return "index";
    }
    
    @RequestMapping(value = "/testPost",method = RequestMethod.POST)
    public String testPost(String username,String password,Model model){
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("data", "SpringBoot JSP页面");
        return "index";
    }
}
