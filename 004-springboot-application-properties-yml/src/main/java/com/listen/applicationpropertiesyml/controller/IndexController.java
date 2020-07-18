package com.listen.applicationpropertiesyml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 李松
 * 2020/7/18
 */
/*
* 当properties和yml两个配置文件文件都存在时，默认使用properties
*/
@Controller
public class IndexController {
    @ResponseBody
    @RequestMapping("/hello")
    public Object hello(){
        return "hello properties and yml";
    }
}
