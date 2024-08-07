package vn.edu.likelion.Warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import vn.edu.likelion.Warehouse.controller.AuthController;
import vn.edu.likelion.Warehouse.controller.ProductController;
import vn.edu.likelion.Warehouse.controller.UserController;
import vn.edu.likelion.Warehouse.controller.WarehouseController;
import vn.edu.likelion.Warehouse.entity.UserEntity;
import vn.edu.likelion.Warehouse.entity.WarehouseEntity;
import vn.edu.likelion.Warehouse.model.UpdateWarehouseModel;

import java.util.Scanner;

@SpringBootApplication
public class WarehouseApplication {
    public static Scanner sc = new Scanner(System.in);
    public static UserEntity user;
    public static int role;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(WarehouseApplication.class, args);

        AuthController authController = context.getBean(AuthController.class);
        ProductController productController = context.getBean(ProductController.class);
        UserController userController = context.getBean(UserController.class);
        WarehouseController warehouseController = context.getBean(WarehouseController.class);

        boolean check = true;
        do {
            try {
                while (user == null) {
                    System.out.print("Please enter your username: ");
                    String username = sc.nextLine();
                    System.out.print("Please enter your password: ");
                    String password = sc.nextLine();

                    authController.login(username, password);
                }
                showMenu(role);

                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        // View info warehouse
                        System.out.print("Enter warehouse id: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.println(warehouseController.findById(id));
                        break;
                    case 2:
                        // insert product into warehouse
                        System.out.print("Enter product name:");
                        String name = sc.nextLine();
                        System.out.print("Enter product description: ");
                        String description = sc.nextLine();
                        System.out.print("Enter product quantity: ");
                        int quantity = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter product price: ");
                        double price = Double.parseDouble(sc.nextLine());

                        if (role == 1) {
                            System.out.print("Enter warehouse id: ");
                            int id2 = Integer.parseInt(sc.nextLine());

                            System.out.println(productController.create(name, description, quantity, price, id2));

                        } else if (role == 2) {
                            int id2 = warehouseController.findByUser(user.getId());
                            System.out.println(productController.create(name, description, quantity, price, id2));
                        } else {
                            System.out.println("You have not permission");
                        }
                        break;
                    case 3:
                        // view all user
                        if (role == 1) {
                            userController.getAllUsers().forEachRemaining(System.out::println);
                        } else {
                            System.out.println("You have not permission");
                        }
                        break;
                    case 4:
                        // create user
                        if (role == 1) {
                            System.out.print("Enter username: ");
                            String username = sc.nextLine();
                            System.out.print("Enter password: ");
                            String password = sc.nextLine();

                            System.out.println(userController.createUser(username, password));
                        } else {
                            System.out.println("You have not permission");
                        }
                        break;
                    case 5:
                        // update user
                        if (role == 1) {
                            System.out.print("Enter fullname: ");
                            String fullname = sc.nextLine();
                            System.out.print("Enter user id: ");
                            int userId = Integer.parseInt(sc.nextLine());
                            System.out.println(userController.updateUser(fullname, userId));
                        } else {
                            System.out.println("You have not permission");
                        }
                        break;
                    case 6:
                        // delete user
                        if (role == 1) {
                            System.out.print("Enter user id: ");
                            int userId = Integer.parseInt(sc.nextLine());
                            userController.deleteUser(userId);
                        } else {
                            System.out.println("You have not permission");
                        }
                        break;
                    case 7:
                        // view all warehouse
                        if (role == 1) {
                            warehouseController.getAll().forEachRemaining(System.out::println);
                        } else {
                            System.out.println("You have not permission");
                        }
                        break;
                    case 8:
                        // create warehouse
                        if (role == 1) {
                            System.out.print("Enter warehouse name: ");
                            String warehouseName = sc.nextLine();
                            System.out.print("Enter warehouse location: ");
                            String warehouseLocation = sc.nextLine();
                            System.out.print("Enter user id to assign (0: skip): ");
                            int userId = Integer.parseInt(sc.nextLine());
                            WarehouseEntity warehouse = new WarehouseEntity();
                            if (userId != 0) {
                                warehouse.setUserId(userController.getUserById(userId));
                            }
                            warehouse.setName(warehouseName);
                            warehouse.setLocation(warehouseLocation);

                            System.out.println(warehouseController.add(warehouse));

                        } else {
                            System.out.println("You have not permission");
                        }
                        break;
                    case 9:
                        // update warehouse
                        if (role == 1) {
                            System.out.print("Enter warehouse id: ");
                            int warehouseId = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter warehouse name: ");
                            String warehouseName = sc.nextLine();
                            System.out.print("Enter warehouse location: ");
                            String warehouseLocation = sc.nextLine();

                            UpdateWarehouseModel model = new UpdateWarehouseModel(warehouseId, warehouseName, warehouseLocation);

                            System.out.println(warehouseController.update(model));

                        } else {
                            System.out.println("You have not permission");
                        }
                        break;
                    case 10:
                        // delete warehouse
                        if (role == 1) {
                            System.out.print("Enter warehouse id: ");
                            int warehouseId = Integer.parseInt(sc.nextLine());

                            warehouseController.delete(warehouseId);

                        } else {
                            System.out.println("You have not permission");
                        }
                        break;
                    case 11:
                        // assign user into warehouse
                        if (role == 1) {
                            System.out.print("Enter warehouse id: ");
                            int warehouseId = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter user id: ");
                            int userId = Integer.parseInt(sc.nextLine());

                            System.out.println(warehouseController.assignUser(warehouseId, userId));

                        } else {
                            System.out.println("You have not permission");
                        }
                        break;
                    case 12:
                        // logout
                        authController.logout();
                        break;
//                case 13:
//                    // export report
//                    exportReport(connectDB);
//                    break;
                    case 0:
                        // exit program
                        check = false;
                        break;
                    default:
                        System.out.println("Invalid option !!!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
            }
        } while (check);
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
        System.out.println("12: Logout                ");
        System.out.println("0: Exit application");
        System.out.println("=====================================");
        System.out.print("Enter your choose: ");
    }
}
