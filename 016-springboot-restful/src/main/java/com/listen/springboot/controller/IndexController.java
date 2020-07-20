package com.listen.springboot.controller;

import com.listen.springboot.domain.User;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Listen
 * @Date: 2020/7/20
 */
@RestController
public class IndexController {
    @RequestMapping(value = "/user/detail")
    public Object detail(Integer id){
        User user = new User(id,"李四");
        return user;
    }

    @RequestMapping(value = "/user/detail/{id}")
    public Object restfulDetail(@PathVariable("id") Integer id){
        User user = new User(id,"孙悟空");
        return user;
    }

    @RequestMapping(value = "/user/detail/{id}/{userName}")
    public Object restfulDetail2(@PathVariable("id")Integer id,@PathVariable("userName")String userName){
        User user = new User(id,userName);
        return user;
    }

    @DeleteMapping(value = "/user/detail/{age}")
    public Object deleteUser(@PathVariable("age")Integer age){
        return age;
    }

    /*
    * 如果项目使用的是Restful风格，那请求方式一定会使用增删改查所对应的请求方式：
    *  增   改   查     删
    * POST，PUT，GET，DELETE
    * 解决请求冲突问题：
    * 1.修改请求方式
    * 2.修改请求路径
    *
    * Restful原则：
    * 1.各个操作使用对应的请求方式
    * 2.请求路径不要出现动词，尽量使用名词
    * 3.分页，排序操作不需要是哟经Restful风格
    * 4.如果传递的参数不是数据库表中字段名或对象的属性名，那么就采用传统方式传递参数
    */

}
