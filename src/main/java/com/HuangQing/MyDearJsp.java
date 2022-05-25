package com.HuangQing;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyDearJsp", value = "/MyDearJsp")
public class MyDearJsp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        String name = request.getParameter("name");
        String clas = request.getParameter("class");
        String ID = request.getParameter("ID");
        PrintWriter writer = response.getWriter();
        writer.println("<br> name :" + name);
        writer.println("<br> class :" + clas);
        writer.println("<br> ID :" + ID);
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }
}
