package com.Casestudy.repository.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conec {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort_manager?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
