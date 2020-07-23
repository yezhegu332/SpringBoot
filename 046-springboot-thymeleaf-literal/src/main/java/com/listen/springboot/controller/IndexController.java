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
    @RequestMapping("/literal")
    public String literal(Model model){
        model.addAttribute("data", "数据");
        return "literal";
    }
}
