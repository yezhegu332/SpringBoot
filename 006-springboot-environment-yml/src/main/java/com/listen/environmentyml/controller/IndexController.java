package com.listen.environmentyml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 李松
 * 2020/7/18
 */
@Controller
public class IndexController {

    @ResponseBody
    @RequestMapping("/hello")
    public Object hello(){
        return "hello multi environment yml";
    }
}
