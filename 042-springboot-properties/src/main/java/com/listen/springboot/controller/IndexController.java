package com.listen.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Listen
 * @Date: 2020/7/23
 */
@Controller
public class IndexController {
    @RequestMapping("/property")
    public String property(Model model) {
        model.addAttribute("data", "黑百合");
        return "property";
    }

    @ResponseBody
    @RequestMapping("/user/add")
    public Object userAdd(Integer id, String username) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("id", id);
        retMap.put("username", username);
        return retMap;
    }

}
