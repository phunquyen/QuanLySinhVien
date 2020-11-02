package com.xtel.training.manage.model;

import com.xtel.training.manage.entities.Student;
import com.xtel.training.manage.manager.StudentManagement;

import java.sql.*;

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
            String sql = "update student SET name = ?, gender = ?, address = ? where id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, std.getName());
            ps.setInt(2, std.getGender());
            ps.setString(3, std.getAddress());
            ps.setInt(4, std.getId());

            ps.execute();
        } finally {
            close(ps);
            close(connection);
        }
    }

//public static void updateStudent() throws SQLException {
//    System.out.println("Sua thong tin theo ma sinh vien");
//    StudentManagement studentManagement = new StudentManagement();
//    studentManagement.inputInfoStudent();
//
//    //Các bước cần làm để lấy dữ liệu trong CSDL ra & hiển thị
//    Connection conn = null;
//    PreparedStatement statement = null;
//    try {
//        //B1. Tạo kết nối tới CSDL
//        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_student", "root", "");
//
//        //B2. Tạo 1 truy vấn tới CSDL
//        //B2.1: Viết 1 lệnh sql lấy danh sách sinh viên
//        String sql = "UPDATE student SET name = ?, gender = ?, address = ? WHERE id = ?";
//        //B2.2: Viết API Java Trúy vấn CSDL
//        statement = conn.prepareCall(sql);
//        statement.setInt(1, studentManagement.getId());
//        statement.setString(2, studentManagement.getName());
//        statement.setInt(3, studentManagement.getGender());
//        statement.setString(4, studentManagement.getAddress());
//        //B2.4: Lấy dữ liệu từ CSDL ra
//        statement.execute();
//    }  finally {
//        //B3. Close connection
//        if (statement != null) {
//            try {
//                statement.close();
//            } catch (SQLException ex) {
//            }
//        }
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException ex) {
//            }
//        }
//    }
//}

    public static void count() throws SQLException {
        try {
            Connection connection = ConnectionFactory.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select count(id) from student");
            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

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
