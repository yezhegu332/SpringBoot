package com.listen.springboot.config;

import com.listen.springboot.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Listen
 * @Date: 2020/7/22
 */
@Configuration  //@Configuration定义此类为配置类
public class FilterConfig {
    @Bean
    public FilterRegistrationBean myFilterRegistrationBean(){
        //注册过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MyFilter());
        filterRegistrationBean.addUrlPatterns("/springboot","/myfilter2");
        return filterRegistrationBean;
    }
}
