package vn.edu.likelion.Ass2_WareHouse.Application;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Scanner;

public class Ass2WareHouseApplication {

    static Scanner sc = new Scanner(System.in);
    static int role = 0;
    static int userId = 0;

    public static void main(String[] args) {
        ConnectDB connectDB = new ConnectDB();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean check = true;
        do {
            while (role == 0) {
                login(connectDB, preparedStatement, resultSet);
            }
            showMenu(role);
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    // View info warehouse
                    viewInfoWarehouse(connectDB, preparedStatement, resultSet);
                    break;
                case 2:
                    // insert product into warehouse
                    if (role == 1) {
                        System.out.print("Enter warehouse id: ");
                        int id2 = Integer.parseInt(sc.nextLine());
                        insertProduct(connectDB, preparedStatement, resultSet, id2);
                    } else if (role == 2) {
                        int id2 = getWarehouseIdByUserId(connectDB, userId);
                        insertProduct(connectDB, preparedStatement, resultSet, id2);
                    } else {
                        System.out.println("You have not permission");
                    }
                    break;
                case 3:
                    // view all user
                    if (role == 1) {
                        viewAllUser(connectDB);
                    } else {
                        System.out.println("You have not permission");
                    }
                    break;
                case 4:
                    // create user
                    if (role == 1) {
                        createUser(connectDB);
                    } else {
                        System.out.println("You have not permission");
                    }
                    break;
                case 5:
                    // update user
                    if (role == 1) {
                        updateUser(connectDB);
                    } else {
                        System.out.println("You have not permission");
                    }
                    break;
                case 6:
                    // delete user
                    if (role == 1) {
                        deleteUser(connectDB);
                    } else {
                        System.out.println("You have not permission");
                    }
                    break;
                case 7:
                    // view all warehouse
                    if (role == 1) {
                        viewAllWarehouse(connectDB);
                    } else {
                        System.out.println("You have not permission");
                    }
                    break;
                case 8:
                    // create warehouse
                    if (role == 1) {
                        createWarehouse(connectDB);
                    } else {
                        System.out.println("You have not permission");
                    }
                    break;
                case 9:
                    // update warehouse
                    if (role == 1) {
                        updateWarehouse(connectDB);
                    } else {
                        System.out.println("You have not permission");
                    }
                    break;
                case 10:
                    // delete warehouse
                    if (role == 1) {
                        deleteWarehouse(connectDB);
                    } else {
                        System.out.println("You have not permission");
                    }
                    break;
                case 11:
                    // assign user into warehouse
                    if (role == 1) {
                        assignUserIntoWarehouse(connectDB);
                    } else {
                        System.out.println("You have not permission");
                    }
                    break;
                case 12:
                    // logout
                    logout();
                    break;
                case 13:
                    // export report
                    exportReport(connectDB);
                    break;
                case 0:
                    // exit program
                    check = false;
                    break;
                default:
                    System.out.println("Invalid option !!!");
                    break;
            }
        } while (check);
    }

    public static void login(ConnectDB conn, PreparedStatement stat, ResultSet rs) {
        try {
            System.out.print("Nhap username: ");
            String username = sc.nextLine();
            System.out.print("Nhap password: ");
            String pass = sc.nextLine();
            String password = Base64.getEncoder().encodeToString(pass.getBytes());

            String query = "select * from users where username = ? and password = ?";
            conn.openConnection();
            stat = conn.getConnection().prepareStatement(query);
            stat.setString(1, username);
            stat.setString(2, password);
            rs = stat.executeQuery();

            if (rs.next()) {
                role = rs.getInt("role");
                userId = rs.getInt("id");
            } else {
                System.out.println("Invalid username or password !!!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void showMenu(int role) {
        System.out.println("=================MENU================");
        System.out.println("1: View info warehouse    -    2: Insert product into warehouse");
        if (role == 1) {
            System.out.println("3: View all user          -    4: Create user");
            System.out.println("5: Update user            -    6: Delete user");
            System.out.println("7: View all warehouse     -    8: Create warehouse");
            System.out.println("9: Update warehouse       -    10: Delete warehouse");
            System.out.println("11: Assign user into warehouse");
        }
        System.out.println("12: Logout                -    13: Export report");
        System.out.println("0: Exit application");
        System.out.println("=====================================");
        System.out.print("Enter your choose: ");
    }

    public static void viewInfoWarehouse(ConnectDB conn, PreparedStatement stat, ResultSet rs) {
        try {
            conn.openConnection();
            int wid = 0;
            if (role == 1) {
                System.out.print("Enter warehouse id: ");
                wid = Integer.parseInt(sc.nextLine());
            } else {
                rs = conn.getConnection().prepareStatement("select id from warehouse where user_id = " + userId)
                        .executeQuery();
                if (rs.next()) {
                    wid = rs.getInt(1);
                }
            }
            String query = "SELECT * FROM WAREHOUSE where id = " + wid;

            stat = conn.openConnection().prepareStatement(query);
            rs = stat.executeQuery();
            if (rs.next()) {
                System.out.println("-----------------------------");
                System.out.print("User: " + rs.getInt(2) +
                        " \t | Warehouse name: " + rs.getString(3) +
                        " \t | Location: " + rs.getString(4));
                System.out.println("\n-----------------------------");

            } else {
                System.out.println("Warehouse not found");
            }
            System.out.println();

            query = "select * from PRODUCT where warehouse_id = " + wid + " order by id asc";

            rs = conn.getConnection().prepareStatement(query).executeQuery();
            while (rs.next()) {
                System.out.println("-----------------------------");
                System.out.print(rs.getInt(1) + "\t| " + rs.getString(3) +
                        "\t| " + rs.getString(4) + "\t| " + rs.getInt(5) +
                        "\t| " + rs.getDouble(6));
                System.out.println("\n-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getWarehouseIdByUserId(ConnectDB conn, int userId) {
        try {
            String query = "SELECT ID FROM WAREHOUSE WHERE USER_ID = " + userId;
            conn.openConnection();
            PreparedStatement stat = conn.getConnection().prepareStatement(query);
            ResultSet rs = stat.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static void insertProduct(ConnectDB conn, PreparedStatement stat, ResultSet rs, int idw) {
        FileInputStream inputStream = null;
        try {
            conn.openConnection();
            rs = conn.getConnection().prepareStatement("select * from warehouse where id = " + idw).executeQuery();
            if (rs.next()) {
                if (rs.getInt("user_id") != 0) {

                    inputStream = new FileInputStream(new File("DanhSachSP.xlsx"));
                    Workbook workbook = WorkbookFactory.create(inputStream);
                    Sheet sheet = workbook.getSheetAt(0);
                    StringBuilder stringBuilder = null;
                    for (int i = 5; i <= sheet.getLastRowNum(); i++) {
                        stringBuilder = new StringBuilder();
                        if (sheet.getRow(i).getCell(1).getCellType() != CellType.BLANK) {
                            for (Cell cell : sheet.getRow(i)) {
                                if (cell.getCellType() != CellType.BLANK) {
                                    switch (cell.getCellType()) {
                                        case STRING:
                                            stringBuilder.append(cell.getStringCellValue()).append("\t");
                                            break;
                                        case NUMERIC:
                                            stringBuilder.append(cell.getNumericCellValue()).append("\t");
                                            break;
                                    }
                                } else break;
                            }

                            int count = 0;
                            rs = conn.getConnection().prepareStatement("select count(*) from product").executeQuery();
                            while (rs.next()) {
                                count = rs.getInt(1) + 1;
                            }
                            String[] string = stringBuilder.toString().split("\t");
                            String query = "insert into product(id, warehouse_id, name, description, amount, price) " +
                                    "values (?, ?, ?, ?, ?, ?)";
                            stat = conn.getConnection().prepareStatement(query);
                            stat.setDouble(1, count);
                            stat.setInt(2, idw);
                            stat.setString(3, string[1]);
                            stat.setString(4, string[2]);
                            stat.setInt(5, (int) Double.parseDouble(string[3]));
                            stat.setDouble(6, Double.parseDouble(string[4]));
                            stat.execute();
                        } else break;
                    }
                    workbook.close();
                    inputStream.close();
                } else {
                    System.out.println("Add fail, having not userid");
                }
            } else {
                System.out.println("Warehouse not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void viewAllUser(ConnectDB conn) {
        try {
            String query = "select * from users order by id asc";
            conn.openConnection();
            ResultSet rs = conn.getConnection().prepareStatement(query).executeQuery();
            while (rs.next()) {
                System.out.println("Id: " + rs.getString(1) +
                        "\t | name: " + rs.getString(2) +
//                        "password: " + rs.getString(3) + "\t" +
                        "\t | role: " + rs.getString(4) +
                        "\t | username: " + rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createUser(ConnectDB conn) {
        try {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String pass = sc.nextLine();
            String password = Base64.getEncoder().encodeToString(pass.getBytes());
            int count = 0;
            conn.openConnection();
            ResultSet rs = conn.getConnection().prepareStatement("select count(*) from users").executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            String query = "insert into users(id, name, password, role, username) values (?, ?, ?, ?, ?)";
            PreparedStatement stat = conn.getConnection().prepareStatement(query);
            stat.setInt(1, ++count);
            stat.setString(2, name);
            stat.setString(3, password);
            stat.setInt(4, 2);
            stat.setString(5, username);
            stat.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void updateUser(ConnectDB conn) {
        try {
            System.out.print("Enter user id: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter new name: ");
            String name = sc.nextLine();
            System.out.print("Enter new username: ");
            String username = sc.nextLine();
            System.out.print("Enter new password: ");
            String pass = sc.nextLine();
            String password = Base64.getEncoder().encodeToString(pass.getBytes());

            conn.openConnection();
            ResultSet rs = conn.getConnection().prepareStatement("select * from users where id = " + id).executeQuery();
            if (rs.next()) {
                String query = "update users set name = ?, username = ?, password = ? where id = ?";
                PreparedStatement stat = conn.getConnection().prepareStatement(query);
                stat.setString(1, name);
                stat.setString(2, username);
                stat.setString(3, password);
                stat.setInt(4, id);
                stat.executeUpdate();

            } else {
                System.out.println("User not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteUser(ConnectDB conn) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            System.out.print("Enter user id: ");
            int id = Integer.parseInt(sc.nextLine());

            conn.openConnection();
            rs = conn.getConnection().prepareStatement("select * from users where id = " + id).executeQuery();
            if (rs.next()) {
                rs = conn.getConnection()
                        .prepareStatement("SELECT * FROM WAREHOUSE WHERE USER_ID = " + id)
                        .executeQuery();
                if (rs.next()) {
                    int warehouseId = rs.getInt(1);
                    rs = conn.getConnection()
                            .prepareStatement("SELECT * FROM PRODUCT WHERE WAREHOUSE_ID = " + id)
                            .executeQuery();
                    if (rs.next()) {
                        System.out.print("Still product in warehouse, enter warehouse id to change: ");
                        int newId = Integer.parseInt(sc.nextLine());

                        rs = conn.getConnection().prepareStatement("select * from warehouse where id = " + newId)
                                .executeQuery();
                        if (rs.next()) {
                            String query = "update product set warehouse_id = ? where warehouse_id = ?";
                            stat = conn.getConnection().prepareStatement(query);
                            stat.setInt(1, newId);
                            stat.setInt(2, warehouseId);
                            stat.executeUpdate();

                            query = "delete from warehouse where id = " + warehouseId;
                            stat = conn.getConnection().prepareStatement(query);
                            stat.execute();

                            query = "delete from users where id = " + id;
                            stat = conn.getConnection().prepareStatement(query);
                            stat.execute();
                        } else {
                            System.out.println("Warehouse not found");
                        }
                    } else {
                        String query = "delete from warehouse where id = " + warehouseId;
                        stat = conn.getConnection().prepareStatement(query);
                        stat.execute();
                    }
                } else {
                    String query = "delete from users where id = " + id;
                    stat = conn.getConnection().prepareStatement(query);
                    stat.execute();
                }
            } else {
                System.out.println("User not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void viewAllWarehouse(ConnectDB conn) {
        try {
            String query = "select * from warehouse order by id asc";
            conn.openConnection();
            ResultSet rs = conn.getConnection().prepareStatement(query).executeQuery();
            while (rs.next()) {
                System.out.println("user: " + rs.getInt(2) +
                        " \t | name: " + rs.getString(3) + "\t" +
                        " \t | location: " + rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createWarehouse(ConnectDB conn) {
        try {
            int count = 0;
            conn.openConnection();
            ResultSet rs = conn.getConnection().prepareStatement("select count(*) from warehouse").executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }

            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter location: ");
            String location = sc.nextLine();
            System.out.println("Do you want to assign user ? (1: yes / 0: no): ");
            int check = Integer.parseInt(sc.nextLine());
            int id;
            String query = null;
            PreparedStatement stat = null;
            if (check == 1) {
                System.out.print("Enter user id to assign: ");
                id = Integer.parseInt(sc.nextLine());
                query = "insert into warehouse(id, user_id, name, location) values (?, ?, ?, ?)";
                stat = conn.getConnection().prepareStatement(query);
                stat.setInt(1, ++count);
                stat.setInt(2, id);
                stat.setString(3, name);
                stat.setString(4, location);
            } else {
                query = "insert into warehouse(id, name, location) values (?, ?, ?)";
                stat = conn.getConnection().prepareStatement(query);
                stat.setInt(1, ++count);
                stat.setString(2, name);
                stat.setString(3, location);
            }
            stat.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void updateWarehouse(ConnectDB conn) {
        try {
            System.out.print("Enter user id: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter new name: ");
            String name = sc.nextLine();
            System.out.print("Enter new location: ");
            String location = sc.nextLine();

            conn.openConnection();
            ResultSet rs = conn.getConnection().prepareStatement("select * from warehouse where id = " + id)
                    .executeQuery();
            if (rs.next()) {
                String query = "update warehouse set name = ?, location = ? where id = ?";
                PreparedStatement stat = conn.getConnection().prepareStatement(query);
                stat.setString(1, name);
                stat.setString(2, location);
                stat.setInt(3, id);
                stat.executeUpdate();

            } else {
                System.out.println("Warehouse not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteWarehouse(ConnectDB conn) {
        try {
            System.out.print("Enter warehouse id: ");
            int id = Integer.parseInt(sc.nextLine());

            conn.openConnection();
            ResultSet rs = conn.getConnection()
                    .prepareStatement("SELECT * FROM WAREHOUSE w JOIN PRODUCT p " +
                            "ON w.ID = p.WAREHOUSE_ID WHERE w.USER_ID = " + id)
                    .executeQuery();
            if (rs.next()) {
                int warehouseId = rs.getInt(1);
                System.out.print("Still product in warehouse, enter warehouse id to change: ");
                int newId = Integer.parseInt(sc.nextLine());

                String query = "update product set warehouse_id = ? where warehouse_id = ?";
                PreparedStatement stat = conn.getConnection().prepareStatement(query);
                stat.setInt(1, newId);
                stat.setInt(2, warehouseId);
                stat.executeUpdate();

                query = "delete from warehouse where id = " + id;

                conn.getConnection().prepareStatement(query).execute();
            } else {
                System.out.println("Warehouse not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void assignUserIntoWarehouse(ConnectDB conn) {
        try {
            System.out.print("Enter user id to assign: ");
            int userId = Integer.parseInt(sc.nextLine());
            System.out.print("Enter warehouse id to assign: ");
            int warehouseId = Integer.parseInt(sc.nextLine());

            conn.openConnection();
            ResultSet rs = null;
            rs = conn.getConnection().prepareStatement("select * from users where id = " + userId).executeQuery();
            if (rs.next()) {
                rs = conn.getConnection().prepareStatement("select * from warehouse where id = " + warehouseId)
                        .executeQuery();
                if (rs.next()) {
                    rs = conn.getConnection().prepareStatement("select * from warehouse where user_id = "
                            + userId).executeQuery();
                    if (rs.next()) {
                        System.out.println("User had warehouse already");
                    } else {
                        String query = "update warehouse set user_id = ? where id = ?";
                        PreparedStatement stat = conn.getConnection().prepareStatement(query);
                        stat.setInt(1, userId);
                        stat.setInt(2, warehouseId);
                        stat.executeUpdate();
                    }
                } else {
                    System.out.println("Warehouse not found");
                }
            } else {
                System.out.println("User not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void logout() {
        role = 0;
        userId = 0;
    }

    public static void exportReport(ConnectDB conn) {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            // Tạo một workbook mới
            conn.openConnection();
            if (role == 1) {
                ResultSet rs = conn.getConnection().prepareStatement("SELECT * FROM warehouse order by id asc")
                        .executeQuery();
                while (rs.next()) {
                    Sheet sheet = workbook.createSheet("Report warehouse " + rs.getString("name")); // Tạo một sheet mới
                    Row row = sheet.createRow(0); // Tạo một hàng mới
                    Cell cell1 = row.createCell(1); // Tạo các ô và đặt giá trị
                    cell1.setCellValue("Id");
                    Cell cell2 = row.createCell(2);
                    cell2.setCellValue("Warehouse_id");
                    Cell cell3 = row.createCell(3);
                    cell3.setCellValue("Name");
                    Cell cell4 = row.createCell(4);
                    cell4.setCellValue("Description");
                    Cell cell5 = row.createCell(5);
                    cell5.setCellValue("Amount");
                    Cell cell6 = row.createCell(6);
                    cell6.setCellValue("Price");
                    int rowNum = 1;

                    ResultSet rs1 = conn.getConnection()
                            .prepareStatement("select * from product where warehouse_id = "
                                    + rs.getInt("id")).executeQuery();
                    while (rs1.next()) {
                        Row row1 = sheet.createRow(rowNum++); // Tạo một hàng mới
                        Cell cell11 = row1.createCell(1); // Tạo các ô và đặt giá trị
                        cell11.setCellValue(rs1.getInt(1));
                        Cell cell21 = row1.createCell(2);
                        cell21.setCellValue(rs1.getInt(2));
                        Cell cell31 = row1.createCell(3);
                        cell31.setCellValue(rs1.getString(3));
                        Cell cell41 = row1.createCell(4);
                        cell41.setCellValue(rs1.getString(4));
                        Cell cell51 = row1.createCell(5);
                        cell51.setCellValue(rs1.getInt(5));
                        Cell cell61 = row1.createCell(6);
                        cell61.setCellValue(rs1.getDouble(6));
                    }
                }
                FileOutputStream out = new FileOutputStream("Report " + userId + ".xlsx"); // Ghi ra file
                workbook.write(out);
                workbook.close();
                System.out.println("Đã tạo file Xlsx thành công!");
            } else if (role == 2) {
                ResultSet rs = conn.getConnection().prepareStatement("SELECT * FROM warehouse w , product p WHERE w.USER_ID = " + userId)
                        .executeQuery();
                Sheet sheet = workbook.createSheet("Report warehouse"); // Tạo một sheet mới
                int rowNum = 1;
                Row row = sheet.createRow(0); // Tạo một hàng mới
                Cell cell1 = row.createCell(1); // Tạo các ô và đặt giá trị
                cell1.setCellValue("Id");
                Cell cell2 = row.createCell(2);
                cell2.setCellValue("Warehouse_id");
                Cell cell3 = row.createCell(3);
                cell3.setCellValue("Name");
                Cell cell4 = row.createCell(4);
                cell4.setCellValue("Description");
                Cell cell5 = row.createCell(5);
                cell5.setCellValue("Amount");
                Cell cell6 = row.createCell(6);
                cell6.setCellValue("Price");
                while (rs.next()) {
                    // neu co kho thi thuc hien xuat bao cao
                    // dau tien la xem san pham trong kho
                    Row row1 = sheet.createRow(rowNum++); // Tạo một hàng mới
                    Cell cell11 = row1.createCell(1); // Tạo các ô và đặt giá trị
                    cell11.setCellValue(rs.getInt(5));
                    Cell cell21 = row1.createCell(2);
                    cell21.setCellValue(rs.getInt(6));
                    Cell cell31 = row1.createCell(3);
                    cell31.setCellValue(rs.getString(7));
                    Cell cell41 = row1.createCell(4);
                    cell41.setCellValue(rs.getString(8));
                    Cell cell51 = row1.createCell(5);
                    cell51.setCellValue(rs.getInt(9));
                    Cell cell61 = row1.createCell(6);
                    cell61.setCellValue(rs.getInt(10));
                }
                FileOutputStream out = new FileOutputStream("Report " + userId + ".xlsx"); // Ghi ra file
                workbook.write(out);
                workbook.close();
                System.out.println("Đã tạo file Xlsx thành công!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.closeConnection();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
