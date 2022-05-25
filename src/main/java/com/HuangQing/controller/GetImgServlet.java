package com.HuangQing.controller;

import com.HuangQing.Dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "GetImgServlet", value = "/getImg")
public class GetImgServlet extends HttpServlet {
    Connection con = null;
    public void init()  {
        con = (Connection)getServletContext().getAttribute("con");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ProductDao dao = new ProductDao();
        int id = 0;
        if(request.getParameter("id") != null){
            id = Integer.parseInt(request.getParameter("id"));
        }
        try {
            byte[] imByte = new byte[0];
            imByte = dao.getPictureById(id,con);
            if(imByte!=null){
                response.setContentType("image/gif");
                OutputStream os = response.getOutputStream();
                os.write(imByte);
                os.flush();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}