package com.example.quan_ly_user_servlet_jdbc.dao;

import com.example.quan_ly_user_servlet_jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    public List<User> selectAllUsers(String country);

}
