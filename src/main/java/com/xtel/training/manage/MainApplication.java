package com.xtel.training.manage;

import com.xtel.training.manage.manager.StudentManagement;
import com.xtel.training.manage.model.StudentDao;

import java.sql.SQLException;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        StudentManagement stdManagement = new StudentManagement();
        StudentDao stdDao = new StudentDao();
        do {
            System.out.println("");
            System.out.println("1.Hien thi thong tin sinh vien");
            System.out.println("2.Them sinh vien.");
            System.out.println("3.Sua sinh vien.");
            System.out.println("4.Xoa sinh vien.");
            System.out.println("5.Thoat!");
            System.out.println("");
            System.out.print("Lua chon:");
            int Option = Integer.parseInt(sc.nextLine());
            switch (Option) {
                case 1:
                    stdDao.getList();
                    break;
                case 2:
                    stdManagement.insertData();
                    break;
                case 3:
                    stdDao.updateStudent();
                    break;
                case 4:
                    stdManagement.deleteData();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
