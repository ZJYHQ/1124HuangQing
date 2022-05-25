package com.HuangQing.controller;

import com.HuangQing.Dao.CategoryDao;
import com.HuangQing.Dao.ProductDao;
import com.HuangQing.model.Category;
import com.HuangQing.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductDetailsServlet", value = "/productDetails")
public class ProductDetailsServlet extends HttpServlet {
    private Connection con = null;
    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = request.getParameter("id") != null ? Integer.parseInt((request.getParameter("id"))) : 0;
        ProductDao productDao = new ProductDao();
        if(id == 0) {
            request.getRequestDispatcher("/image/404/404.png").forward(request,response);
        } else {
            try {
                CategoryDao categoryDao = new CategoryDao();
                List<Category> allCategory = categoryDao.findAllCategory(con);
                request.setAttribute("categoryList", allCategory);
            } catch (SQLException e) {
                System.out.println(e);
            }

            try {
                Product byId = productDao.findById(id, con);
                request.setAttribute("p", byId);
            }catch (SQLException e) {
                System.out.println(e);
            }
            request.getRequestDispatcher("WEB-INF/views/productDetails.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}