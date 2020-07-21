package com.listen.springboot;

import com.listen.springboot.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //SpringBoot程序启动后，返回值是ConfigurableApplicationContext，它也是一个Spring容器对象
        //它相当于ClassPathXmlApplication
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        //从容器中获取指定bean对象
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        //调用业务方法
        String sayHello = userService.satHello();
        System.err.println(sayHello);
    }
}
