package com.HuangQing.week6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String txt = request.getParameter("txt");
        String Search = request.getParameter("search");
        System.out.println(txt + "\n" + Search);
        System.out.println("https://baidu.com/s?wd=" + txt);
        if(Search.equals("baidu")) {
            response.sendRedirect("https://baidu.com/s?wd=" + txt);
        } else if(Search.equals("bing")) {
            response.sendRedirect("https://cn.bing.com/search?q=" + txt);
        } else {
            response.sendRedirect("https://www.google.com/search?q=" + txt);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
