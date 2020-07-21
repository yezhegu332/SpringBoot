package com.listen.springboot.config;

import com.listen.springboot.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Listen
 * @Date: 2020/7/21
 */
@Configuration  //用于定义配置类，如果类上有此注解，那么此类就为一个配置类，他相当于替换了之前的xml配置文件
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] addPathPatterns = {"/user/**"};
        String[] excludePathPatterns = {"/user/page/login","/user/login"};
        registry.addInterceptor(new UserInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
