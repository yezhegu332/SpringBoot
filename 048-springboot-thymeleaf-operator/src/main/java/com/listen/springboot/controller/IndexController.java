package com.listen.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Listen
 * @Date: 2020/7/23
 */
@Controller
public class IndexController {
    @RequestMapping("/operator")
    public String operator(Model model){
        model.addAttribute("sex", 1);
        model.addAttribute("flag", true);
        return "operator";
    }
}
