package com.xtel.training.manage.model;

import com.xtel.training.manage.entities.Student;

import java.sql.*;
import java.util.List;

public class StudentDao {
    public static void getList() {
        try {
            Connection connection = ConnectionFactory.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
            // show data
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "  " + resultSet.getString(2)
                        + "  " + resultSet.getString(3) + "  " + resultSet.getString(4));
            }
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void insert(Student std) throws SQLException {
        Connection connection = ConnectionFactory.createConnection();
        PreparedStatement ps = null;
        try {
            String sql = "insert into student(id, name, gender, address) values(?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, std.getId());
            ps.setString(2, std.getName());
            ps.setInt(3, std.getGender());
            ps.setString(4, std.getAddress());
            ps.execute();
        } finally {
            close(ps);
            close(connection);
        }
    }
    public static void update(Student std) throws SQLException {
        Connection connection = ConnectionFactory.createConnection();
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE student SET name = ?, gender = ?, address = ? WHERE id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, std.getId());
            ps.setString(2, std.getName());
            ps.setInt(3, std.getGender());
            ps.setString(4, std.getAddress());
            ps.execute();
        } finally {
            close(ps);
            close(connection);
        }
    }
//    public static void update(Student std) throws SQLException {
//        Connection connection = ConnectionFactory.createConnection();
//        PreparedStatement ps = null;
//        try {
//            String sql = "UPDATE student SET name = ?, gender = ?, address = ? WHERE id = ?";
//            ps = connection.prepareStatement(sql);
//            ps.setInt(1, std.getId());
//            ps.setString(2, std.getName());
//            ps.setInt(3, std.getGender());
//            ps.setString(4, std.getAddress());
//            ps.execute();
//        } finally {
//            close(ps);
//            close(connection);
//        }
//    }

    public static void delete(int id) throws SQLException {
        Connection connection = ConnectionFactory.createConnection();
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM student WHERE id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } finally {
            close(ps);
            close(connection);
        }
    }

    public static void close(AutoCloseable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
