package com.listen.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Listen
 * @Date: 2020/7/20
 */
//@Controller
@RestController //相当于 类上加@Controller + 方法加@ResponseBody
public class IndexController {

    @RequestMapping("/index")
    public Object index(){
        return "INDEX";
    }

    @RequestMapping(value = "/index1",method = {RequestMethod.GET,RequestMethod.POST})
    public Object index1(){
        return "INDEX1";
    }

    //该方法只支持GET
    @RequestMapping(value = "/index2",method = RequestMethod.GET)
    public Object index2(){
        return "INDEX2";
    }

    //该方法只支持GET
    @GetMapping(value = "/index3")
    public Object index3(){
        return "@GetMapping";
    }

    @RequestMapping(value = "/index4",method = RequestMethod.POST)
    public Object index4(){
        return "Only POST Method!";
    }

    //该方法只支持POST
    @PostMapping(value = "/index5")
    public Object index5(){
        return "Only POST Method!";
    }

    //该方法只支持DELETE
    //通常是在做删除数据的操作
    @RequestMapping(value = "/delete",method=RequestMethod.DELETE)
    public Object delete(){
        return "Only DELETE Method!";
    }

    @DeleteMapping(value = "/delete2")
    public Object delete2(){
        return "Only DELETE2 Method!";
    }

    //该方法只支持PUT
    //通常是使用在更新操作
    @RequestMapping(value = "/put",method=RequestMethod.PUT)
    public Object put(){
        return "Only PUT Method!";
    }

    @PutMapping(value = "/put2")
    public Object put2(){
        return "Only PUT2 Method!";
    }
}
