package com.HuangQing.Dao;

import com.HuangQing.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("insert into user values ('" + user.getID() + "', '" + user.getName() + "', '" + user.getPassword() + "', '" +
                    user.getEmail() + "', '" + user.getGender() + "', '" + user.getBirthdate() + "');");
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    @Override
    public String deleteUser(Connection con, User user) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("delete from user where ID = '" + user.getID() + "'");
            ps.executeUpdate();
            return user.getID();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public String updateUser(Connection con, User user) throws SQLException {
        String sql = "update user set name = '" + user.getName() + "', password = '" + user.getPassword() +
                "', Email='" + user.getEmail() + "', Gender='" + user.getGender() + "', Birthdate='" + user.getBirthdate() + "'" +
                "where ID ='" + user.getID() + "';";
        try {
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return user.getID();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        return null;
    }

    @Override
    public User findById(Connection con, String id) throws SQLException {
        String sql = "select * from user where ID = '" + id + "';";
        User user = null;
        try {
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user = new User();
                user.setID(rs.getString("ID"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("Email"));
                user.setGender(rs.getString("Gender"));
                user.setBirthdate(rs.getString("Birthdate"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql = "select * from user where password = '" + password + "';";
        User user = null;
        try {
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user = new User();
                user.setID(rs.getString("ID"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("Email"));
                user.setGender(rs.getString("Gender"));
                user.setBirthdate(rs.getString("Birthdate"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql = "select * from user where name = '" + username + "';";
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getString("ID"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("Email"));
                user.setGender(rs.getString("Gender"));
                user.setBirthdate(rs.getString("Birthdate"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return users;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql = "select * from user where password = '" + password + "';";
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getString("ID"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("Email"));
                user.setGender(rs.getString("Gender"));
                user.setBirthdate(rs.getString("Birthdate"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return users;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql = "select * from user where Email = '" + email + "';";
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getString("ID"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("Email"));
                user.setGender(rs.getString("Gender"));
                user.setBirthdate(rs.getString("Birthdate"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return users;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql = "select * from user where Gender = '" + gender + "';";
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getString("ID"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("Email"));
                user.setGender(rs.getString("Gender"));
                user.setBirthdate(rs.getString("Birthdate"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return users;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, String birthDate) throws SQLException {
        String sql = "select * from user where BirthDate = '" + birthDate + "';";
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getString("ID"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("Email"));
                user.setGender(rs.getString("Gender"));
                user.setBirthdate(rs.getString("Birthdate"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return users;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "select * from user ;";
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getString("ID"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("Email"));
                user.setGender(rs.getString("Gender"));
                user.setBirthdate(rs.getString("Birthdate"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return users;
    }
}