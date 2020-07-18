package com.listen.springboot.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 李松
 * 2020/7/18
 */
@Controller
public class IndexController {
    @Value("${school.name}")
    private String schoolName;

    @Value("${websit}")
    private String websit;

    @Value("${city}")
    private String city;

    @ResponseBody
    @RequestMapping("/index")
    public String index() {
        return "schoolName：" + schoolName + "，websit：" + websit + "，city：" + city;
    }
}
