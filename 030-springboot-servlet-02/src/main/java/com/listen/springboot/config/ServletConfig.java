package com.listen.springboot.config;

import com.listen.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Listen
 * @Date: 2020/7/21
 */
@Configuration  //将此类定义为一个配置类
public class ServletConfig {

    //@Bean是一个方法级别上的注解，主要用在配置类里
    /*<beans>
        <bean id="" class=""></bean>
    </beans>*/
    @Bean
    public ServletRegistrationBean myServletRegistrationBean(){
        //将自定义的servlet注册到注册Servlet类中，并指定访问路径
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet2");
        return servletRegistrationBean;
    }
}
