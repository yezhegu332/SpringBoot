package com.listen.springboot.controller;

import com.listen.springboot.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Listen
 * @Date: 2020/7/23
 */
@Controller
public class EachController {

    @RequestMapping("/each/list")
    public String eachList(Model model) {
        List<User> userList = new ArrayList<>();
        User user = null;
        for (int i = 0; i < 5; i++) {
            user = new User();
            user.setId(1001 + i);
            user.setName("孙悟空" + i);
            user.setPhone("1234560" + i);
            user.setAddress("花果山水帘洞" + i);
            userList.add(user);
        }
        model.addAttribute("userList", userList);
        return "eachList";
    }

    @RequestMapping("/each/map")
    public String eachMap(Model model) {
        Map<Integer, Object> userMaps = new HashMap<>();
        User user = null;
        for (int i = 0; i < 5; i++) {
            user = new User();
            user.setId(1001 + i);
            user.setName("孙悟空" + i);
            user.setPhone("1234560" + i);
            user.setAddress("花果山水帘洞" + i);
            userMaps.put(i, user);
        }
        model.addAttribute("userMaps", userMaps);
        return "eachMap";
    }

    @RequestMapping("/each/array")
    public String eachArray(Model model) {
        User[] userArray = new User[5];
        User user = null;
        for (int i = 0; i < 5; i++) {
            user = new User();
            user.setId(1001 + i);
            user.setName("孙悟空" + i);
            user.setPhone("1234560" + i);
            user.setAddress("花果山水帘洞" + i);
            userArray[i] = user;
        }
        model.addAttribute("userArray", userArray);
        return "eachArray";
    }

    @RequestMapping(value = "/each/all")
    public String eachAll(Model model) {
    //list -> Map -> List -> User
    List<Map<Integer, List<User>>> myList = new ArrayList<>();
    for (int i = 0; i < 2; i++) {
        Map<Integer, List<User>> myMap = new HashMap<>();
        for (int j = 0; j < 2; j++) {
            List<User> myUserList = new ArrayList<>();
            for (int k = 0; k < 3; k++) {
                User user = new User();
                user.setId(k);
                user.setName("张三" + k);
                user.setPhone("1350000000" + k);
                user.setAddress("广州市" + i);
                myUserList.add(user);
            }
            myMap.put(j, myUserList);
        }
        myList.add(myMap);
    }
        model.addAttribute("myList", myList);
        return "eachAll";
    }
}
