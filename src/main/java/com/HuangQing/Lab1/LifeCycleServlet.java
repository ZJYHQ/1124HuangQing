package com.HuangQing.Lab1;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LifeCycleServlet extends HttpServlet {

    private String time;
    private int t;
    public void def(){
        System.out.println("I Am from default constructor");
    }

    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
        time = "Since loading,this servlet has been accessed"+t+"times";

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws  ServletException, IOException {
        response.setContentType("text/html");
        t=t++;
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + time + "</h1>");
        out.println("</body></html>");


        System.out.println("service");
//System.out.println(getServletConfig().getInitParameter("email"));
    }
    public void destroy() {
        System.out.println("destroy");
    }
}
