package com.listen.springboot;

import com.listen.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    //通过容器获取bean对象，并注入给userService
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        //SpringBoot启动应用程序，会初始化Spring容器
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //容器启动后调用run方法，在该方法中调用业务方法
        System.err.println(userService.sayHello());
    }
}
