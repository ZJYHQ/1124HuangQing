package com.HuangQing.week5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String usr = getServletContext().getInitParameter("usr");
        String password = getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usr, password);
            System.out.println("连接成功");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("ID");
        String password = request.getParameter("password");
        String sql = "select * from user where ID =" + id + ";";

        System.out.println(sql);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            boolean ok = false;
            while (rs.next()) {
                String t = rs.getString("password");
                String name = rs.getString("name");
                if(t.equals(password)) {
                    PrintWriter writer = response.getWriter();
                    writer.println("<h1>Login success!!!</h1>");
                    writer.println("<p>Welcome " + name + "</p>");
                    request.setAttribute("id", rs.getString("id"));
                    request.setAttribute("name", rs.getString("name"));
                    request.setAttribute("password", rs.getString("password"));
                    request.setAttribute("email", rs.getString("email"));
                    request.setAttribute("gender", rs.getString("gender"));
                    request.setAttribute("birthdate", rs.getString("birthdate"));
                    request.getRequestDispatcher("usrInfo.jsp").forward(request,response);
                    ok = true;
                } else {
                    PrintWriter writer = response.getWriter();
                    writer.println("<h1>Error success!!!</h1>");
                    writer.println("<p>Please Try again</P>");
                    request.setAttribute("messsage", "ID or password Error !!! ");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            }
            if(!ok) {
                PrintWriter writer = response.getWriter();
                writer.println("<h1>Error success!!!</h1>");
                writer.println("<p>Please Try again</P>");
                System.out.println("Fail Login!!!");
                request.setAttribute("message", "ID or password Error !!! ");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
