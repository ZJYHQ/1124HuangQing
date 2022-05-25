package com.HuangQing.week2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Studengt Info Servlet", urlPatterns = "/hello")
public class StudentInfoServlet extends HttpServlet {
    private String Name;
    private String ID;
    private String Time;

    public void init(){
        Name = "NAME:HuangQing";
        ID   =  "ID:2020211001001124";
        Time = "Date and Time Tuesday, March 8, 2022 at 12:00";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + Name + "</h1>");
        out.println("<h1>" + ID + "</h1>");
        out.println("<h1>" + Time + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
