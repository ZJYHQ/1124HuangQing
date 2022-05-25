package com.HuangQing.week5;

import com.HuangQing.Dao.UserDao;
import com.HuangQing.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/Login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        UserDao userdao = new UserDao();
        try {
            User user = userdao.findByUsernamePassword(con, name, password);
            if (user != null) {
                if (req.getParameter("rememberMe") != null && req.getParameter("rememberMe").equals("1")) {
                    Cookie usernameCookie = new Cookie("cUsername", user.getName());
                    Cookie passwordCookie = new Cookie("cpassword", user.getPassword());
                    Cookie rememberMeCookie = new Cookie("crememberMe", req.getParameter("rememberMe"));
                    usernameCookie.setMaxAge(20);
                    passwordCookie.setMaxAge(20);
                    rememberMeCookie.setMaxAge(20);
                    resp.addCookie(usernameCookie);
                    resp.addCookie(passwordCookie);
                    resp.addCookie(rememberMeCookie);
                }
                // 创建一个session
                HttpSession session = req.getSession();
                System.out.println("session id -> " + session.getId());
                session.setMaxInactiveInterval(3600);
                session.setAttribute("user", user);
                req.getRequestDispatcher("WEB-INF/views/usrInfo.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "Username or password is Error !!!");
                System.out.println(req.getContextPath() + "/WEB-INF/views/login.jsp");
                req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

            super.destroy();
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
