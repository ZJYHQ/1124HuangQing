package com.HuangQing.Lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/lab2/welcome.jsp","/lab2/validate.jsp"})

public class LoginFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        System.out.println("I am inLoginFilter-->init()");
    }


    public void destroy() {
        System.out.println("I am inLoginFilter-->destroy()");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("I am inLoginFilter-->doFilter()--request before chain");
        chain.doFilter(request, response);

        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;

        if (req.getSession().isNew()){
            req.getRequestDispatcher("welcome.jsp").forward(req,res);
        }else {res.sendRedirect("login.jsp");}

        System.out.println("I am inLoginFilter-->destroy() response after chain");
    }
}
