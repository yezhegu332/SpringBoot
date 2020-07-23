package com.listen.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Listen
 * @Date: 2020/7/23
 */
@Controller
public class PageController {
    @RequestMapping("/splicing")
    public String splicing(Model model){
        model.addAttribute("totalRows", 10);
        model.addAttribute("totalPage", 20);
        model.addAttribute("currentPage", 15);
        return "splicing";
    }

}
