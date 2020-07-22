package com.listen.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Listen
 * @Date: 2020/7/22
 */
@Controller
public class IndexController {

    @ResponseBody
    @RequestMapping(value = "/index")
    public Object index(){
        return "这次是war包";
    }
}
