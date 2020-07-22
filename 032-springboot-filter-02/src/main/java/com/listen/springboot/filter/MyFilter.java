package com.listen.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: Listen
 * @Date: 2020/7/22
 */
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("================进入Filter");
    }
}
