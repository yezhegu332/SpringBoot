package com.listen.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Listen
 * @Date: 2020/7/23
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        request.getSession().setAttribute("username", "孙悟空");
        return "index";
    }

    @RequestMapping("/functionObject")
    public String functionObject(Model model){
        model.addAttribute("curTime", new Date());
        model.addAttribute("curDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
        return "functionObject";
    }
}
