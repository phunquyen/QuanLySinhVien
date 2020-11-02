package com.xtel.training.manage.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static String URL = "jdbc:mysql://localhost:3306/db_student";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }
}
