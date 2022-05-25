package com.HuangQing.controller;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class characterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("characterEncodingFilter初始化");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html; charset=UTF-8");
//        servletResponse.setCharacterEncoding("utf-8");

//        servletResponse.setContentType("text/html; charset=UTF-8");
//        System.out.println("characterEncodingFilter执行前......\n");
        filterChain.doFilter(servletRequest, servletResponse);
//        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("characterEncodingFilter执行后......\n");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String url = httpServletRequest.getRequestURI();
        if(url.endsWith(".css") || url.endsWith(".js") || url.endsWith(".png")) {

        } else {
            servletResponse.setContentType("text/html;charset=utf-8");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
//        System.out.println("characterEncodingFilter销毁");
    }
}