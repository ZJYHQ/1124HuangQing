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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("ID");
        String password = req.getParameter("password");
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
                    PrintWriter writer = resp.getWriter();
                    writer.println("<h1>Login success!!!</h1>");
                    writer.println("<p>Welcome " + name + "</p>");
                    ok = true;
                } else {
                    PrintWriter writer = resp.getWriter();
                    writer.println("<h1>Error success!!!</h1>");
                    writer.println("<p>Please Try again</P>");
                }
            }
            if(!ok) {
                PrintWriter writer = resp.getWriter();
                writer.println("<h1>Error success!!!</h1>");
                writer.println("<p>Please Try again</P>");
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
