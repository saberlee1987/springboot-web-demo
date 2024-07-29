package com.saber.springbootwebdemo.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;


import java.io.IOException;

@Component
public class SimpleCorsOrigin implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", CorsConfiguration.ALL);
        response.setHeader("Access-Control-Allow-Methods", CorsConfiguration.ALL);
        response.setHeader("Access-Control-Max-Age", "30000");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", CorsConfiguration.ALL);
        filterChain.doFilter(request, response);
    }
}
