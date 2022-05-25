package com.HuangQing.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "/admin/*")
public class AdminAuthenticationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        chain.doFilter(request, response);
        HttpServletRequest httprequest = (HttpServletRequest) request;
        HttpServletResponse httpresponse = (HttpServletResponse) response;
        HttpSession session = httprequest.getSession(false);
        boolean isLogin = (session != null && session.getAttribute("userList") != null);
        String loginURL = httprequest.getContextPath() + "/admin/login";
        boolean isLoginrequest = httprequest.getRequestURI().equals(loginURL);
        boolean isloginPage = httprequest.getRequestURI().endsWith("login");

        if(isLogin && (isLoginrequest || isloginPage)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/home");
            dispatcher.forward(request, response);
        } else if(isLogin || isLoginrequest) {
            chain.doFilter(request, response);
        } else {
            httpresponse.sendRedirect(httprequest.getContextPath() + "admin/login");
        }
    }
}