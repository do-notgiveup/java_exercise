package vn.edu.likelion.Service;

import vn.edu.likelion.Application.Main;

import java.sql.*;
import java.util.*;

public class Services {
    String query = "";

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public Services(Connection connection) {
        this.connection = connection;
    }

    public String checkLogin(String userName, String password) {
        try {
            password = new String(Base64.getEncoder().encode(password.getBytes()));
            query = "select id from useraccount where username = ? and password = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public void showPermission(String userId) {
        try {
            Scanner sc = new Scanner(System.in);
//            int count = 0;

            int flag = 0;
            do {
                query = "select * from rolepermission join permission on " +
                        "permission.id = rolepermission.permissionid where roleid = " + userId;
//            query = "select * from permission order by id asc";
                resultSet = connection.prepareStatement(query).executeQuery();

                System.out.println("----------------------------------------------");
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(4) + " " + resultSet.getString(5));
//                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
//                count++;
                }
                System.out.println("----------------------------------------------");


                System.out.print("nhap lua chon cua ban: ");
                int choose = Integer.parseInt(sc.nextLine());
                query = "select * from rolepermission where rolepermission.roleid = " + userId +
                        " and rolepermission.permissionid = " + choose;
                resultSet = connection.prepareStatement(query).executeQuery();
//                if ((1 <= choose) && (choose <= count)) {
                if (resultSet.next()) {
                    switch (choose) {
                        case 1: // xem danh sach hoc vien
                            query = "select * from hocvien order by id asc";
                            resultSet = connection.prepareStatement(query).executeQuery();
                            while (resultSet.next()) {
                                System.out.print(resultSet.getInt(1) + "\t"
                                        + resultSet.getString(2) + "\t"
                                        + (resultSet.getString(3).equals("1") ? "Vắng" : "Học"));
                                System.out.println();
                            }
                            break;
                        case 2: // xem hoc vien vang
                            query = "select * from hocvien where hocvien.status = 1 order by id asc";
                            resultSet = connection.prepareStatement(query).executeQuery();
                            while (resultSet.next()) {
                                System.out.print(resultSet.getInt(1) + "\t"
                                        + resultSet.getString(2) + "\t"
                                        + (resultSet.getString(3).equals("1") ? "Vắng" : "Học"));
                                System.out.println();
                            }
                            break;
                        case 3: // xem hoc vien co mat
                            query = "select * from hocvien where hocvien.status = 0 order by id asc";
                            resultSet = connection.prepareStatement(query).executeQuery();
                            while (resultSet.next()) {
                                System.out.print(resultSet.getInt(1) + "\t"
                                        + resultSet.getString(2) + "\t"
                                        + (resultSet.getString(3).equals("1") ? "Vắng" : "Học"));
                                System.out.println();
                            }
                            break;
                        case 4: // diem danh
                            List<String> list = new ArrayList<>();
                            query = "select * from hocvien order by id asc";
                            resultSet = connection.prepareStatement(query).executeQuery();
                            while (resultSet.next()) {
//                                list.add((resultSet.getString(1) + "\t"
//                                        + resultSet.getString(2) + "\t"));
                                int status = 0;
                                do {
                                    System.out.print(resultSet.getInt(1) + "\t"
                                            + resultSet.getString(2) + "\t"
                                            + "(1: vang; 0: hoc)" + "\t");
                                    status = Integer.parseInt(sc.nextLine());
                                } while (status != 0 && status != 1);

                                query = "update hocvien set status = ? where id = ?";
                                preparedStatement = connection.prepareStatement(query);
                                preparedStatement.setInt(1, status);
                                preparedStatement.setInt(2, resultSet.getInt(1));
                                preparedStatement.executeUpdate();

                            }

//                            for (String s : list) {
//                                System.out.print(s);
//                                String status = sc.nextLine();
//
//                                query = "update hocvien set status = ? where id = ?";
//                                preparedStatement = connection.prepareStatement(query);
//                                preparedStatement.setString(1, status);
//                                preparedStatement.setInt(2, Integer.parseInt(s.split("\t")[0]));
//
//                                preparedStatement.executeUpdate();
//                                preparedStatement.close();
//                            }
                            break;
                        default:
                            System.out.println("ban khong co quyen thuc hien chuc nang nay !!!");
                            break;
                    }
                } else {
                    System.out.println("ban khong co quyen thuc hien chuc nang nay !!!");
                    flag++;
                }
            } while (flag <= 3);
            Main.check = false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
