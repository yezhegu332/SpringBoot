package com.listen.springboot.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @Author: Listen
 * @Date: 2020/7/22
 */
@Configuration
public class SystemConfig {
    @Bean
    public FilterRegistrationBean characterFilterRegistrationBean(){
        //创建字符编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        //强制使用指定的字符编码
        characterEncodingFilter.setForceEncoding(true);
        //指定字符编码
        characterEncodingFilter.setEncoding("UTF-8");
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //设置字符编码过滤器
        filterRegistrationBean.setFilter(characterEncodingFilter);
        //设置字符编码过滤器的路径
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
