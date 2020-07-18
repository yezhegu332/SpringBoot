package com.listen.springboot.controller;

import com.listen.springboot.model.City;
import com.listen.springboot.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 李松
 * 2020/7/18
 */
@Controller
public class IndexController {
    @Autowired
    private School school;

    @Autowired
    private City city;

    @ResponseBody
    @RequestMapping("/index")
    public String index() {
        return "schoolName：" + school.getName() + "，schoolPhone：" + school.getPhone() + "，cityName：" + city.getName() + "，cityPhone：" + city.getPhone();
    }
}
