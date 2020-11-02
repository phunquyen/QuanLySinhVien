package com.xtel.training.manage.manager;

import com.xtel.training.manage.entities.Student;
import com.xtel.training.manage.model.StudentDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement extends Student {
    Scanner scanner = new Scanner(System.in);
    List<Student> studentList = new ArrayList<>();

    public void insertData() {
        System.out.print("Moi nhap so sinh vien: ");
        int numberOfStudent = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfStudent; i++) {
            Student student = inputInfoStudent();
            studentList.add(student);
        }

        for (Student student : studentList) {
            try {
                StudentDao.insert(student);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateData() throws SQLException {
        // update ai ?
        System.out.print("Ma sinh vien can sua: ");
        int idUpdate = Integer.parseInt(scanner.nextLine());
        // update cai gi?
        System.out.print("Ten sinh vien: ");
        String name = scanner.nextLine();
        System.out.print("Gioi tính: ");
        int gender = Integer.parseInt(scanner.nextLine());
        System.out.print("Dia chi: ");
        String address = scanner.nextLine();
        Student std = new Student(idUpdate, name, gender, address);
        StudentDao.update(std);
    }

    public Student inputInfoStudent() {
        System.out.print("Ma sinh vien: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Ten sinh vien: ");
        String name = scanner.nextLine();
        System.out.print("Gioi tính: ");
        int gender = Integer.parseInt(scanner.nextLine());
        System.out.print("Dia chi: ");
        String address = scanner.nextLine();
        return new Student(id, name, gender, address);
    }

    public void deleteData() throws SQLException {
        System.out.print("Nhap MSV Can Xoa: ");
        int idDelete = Integer.parseInt(scanner.nextLine());
        StudentDao.delete(idDelete);
    }

    public int inputId() {
        System.out.print("Ma sinh vien: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("Khong hop le! Moi nhap lai: ");
            }
        }
    }

    private String inputName() {
        System.out.print("Ten sinh vien: ");
        return scanner.nextLine();
    }

    private String inputAddress() {
        System.out.print("Dia chi: ");
        return scanner.nextLine();
    }

    public int inputGender() {
        System.out.print("Gioi tinh: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("Khong hop le! Moi nhap lai: ");
            }
        }
    }
}
