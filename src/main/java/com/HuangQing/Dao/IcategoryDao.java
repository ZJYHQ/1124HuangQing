package com.HuangQing.Dao;

import com.HuangQing.model.Category;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IcategoryDao {

    public List<Category> findAllCategory(Connection con) throws SQLException;

    public String findByCategoryId(Connection con, int categoryId) throws SQLException;

}