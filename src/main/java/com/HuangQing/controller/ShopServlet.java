package com.HuangQing.controller;

import com.HuangQing.Dao.CategoryDao;
import com.HuangQing.Dao.ProductDao;
import com.HuangQing.model.Category;
import com.HuangQing.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {
    private Connection con = null;
    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            CategoryDao categoryDao = new CategoryDao();
            List<Category> allCategory = categoryDao.findAllCategory(con);

            request.setAttribute("categoryList", allCategory);
        } catch (SQLException e) {
            System.out.println(e);
        }
        ProductDao productDao = new ProductDao();
        List<Product> productList = null;
        try {
            if (request.getParameter("categoryId") == null) {
                productList = productDao.findAll(con);
            } else {
                int categoryId = Integer.parseInt(request.getParameter("categoryId"));
                productList = productDao.findByCategoryId(categoryId, con);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("/WEB-INF/views/shop.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
