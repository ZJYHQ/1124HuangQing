package com.HuangQing.week3;

import com.HuangQing.model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "RegisterServlet" ,urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    public void init() throws ServletException {
        ServletConfig config=getServletConfig();
        config.getInitParameter("");
        String driver=config.getInitParameter("driver");
        String url=config.getInitParameter("url");
        String username=config.getInitParameter("username");
        String password=config.getInitParameter("password");
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection -->" + con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection false");
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String id = request.getParameter("username");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String Birthdate = request.getParameter("birthdate");
        String sql = "insert into user values ('" + id + "', '" + username + "', '" + password + "', '" +
                email + "', '" + gender + "', '" + Birthdate + "');";
        System.out.println(sql);
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("插入成功");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<User> list = new ArrayList<User>();
        User x = new User();

        try {
            ps = con.prepareStatement("select  * from user");
            ResultSet rs = null;
            rs = ps.executeQuery();
            while (rs.next()) {
                x = new User();
                x.setID(rs.getString("ID"));
                x.setName(rs.getString("name"));
                x.setPassword(rs.getString("password"));
                x.setEmail(rs.getString("Email"));
                x.setGender(rs.getString("Gender"));
                x.setBirthdate(rs.getString("Birthdate"));
                list.add(x);
            }
            PrintWriter writer = response.getWriter();
            writer.println("<table border=\"1\">  <tr> <th>ID</th> <th>name</th> <th>password</th> <th>Email</th> <th>Gender</th> <th>Birthdate</th> </tr>");
            for (User ur: list) {
                writer.println("<tr>");
                writer.println("<td>" + ur.getID() + "</td>"
                        + "<td>" + ur.getName() + "</td>"
                        + "<td>" + ur.getPassword() + "</td>"
                        + "<td>" + ur.getEmail() + "</td>"
                        + "<td>" + ur.getGender() + "</td>"
                        + "<td>" + ur.getBirthdate() + "</td>");
                writer.println("</tr>");
            }
            writer.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

