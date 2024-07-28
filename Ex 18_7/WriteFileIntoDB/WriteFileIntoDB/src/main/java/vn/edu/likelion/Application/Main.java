package vn.edu.likelion.Application;

import jdk.jshell.spi.ExecutionControlProvider;
import vn.edu.likelion.Service.Services;
import vn.edu.likelion.WriteFileIntoDB.WriteFileIntoDbApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static boolean check = true;

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:orcl21";
        String user = "sys as sysdba";
        String pass = "Admin123";

        // doc file StudentsList.txt va ghi vao DB
        WriteFileIntoDbApplication.writeFileIntoDb(url, user, pass);
        
        // thuc hien cac chuc nang
        do {
            try (Connection connection = DriverManager.getConnection(url, user, pass)) {

                Services services = new Services(connection);
                Scanner sc = new Scanner(System.in);

                System.out.print("nhap username: ");
                String userName = sc.nextLine();
                System.out.print("nhap pass: ");
                String password = sc.nextLine();
                System.out.println(new String(Base64.getEncoder().encode(password.getBytes())));

                String userId = services.checkLogin(userName, password);

                if (userId != null) {
                    services.showPermission(userId);
                } else {
                    System.out.println("username hoac password khong dung !!!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (check);
    }
}
