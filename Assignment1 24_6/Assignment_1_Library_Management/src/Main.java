import vn.edu.likelion.librarymanagement.Applications.BookApplication;
import vn.edu.likelion.librarymanagement.Applications.BorrowerApplication;
import vn.edu.likelion.librarymanagement.Entities.Book;
import vn.edu.likelion.librarymanagement.Entities.Borrower;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner((System.in));

    public static void main(String[] args) {

        BookApplication BookApplication = new BookApplication();
        BorrowerApplication borrowerApplication = new BorrowerApplication();

        //choice for super switch
        int choice = 0;
        //id of book/borrower in application
        int idBook = 1;
        int idBorrower = 1;

        do {
            try {

                //show menu
                getMenu();

                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    // start view list book
                    case 1: {
                        //choice for sub menu 1
                        int choice1 = 0;

                        do {
                            //show list all book before show sub menu 1
                            System.out.println("--------------------------------------");
                            System.out.println("List book: ");
                            BookApplication.viewAllBook();
                            getSubMenu1();

                            choice1 = Integer.parseInt(sc.nextLine());
                            switch (choice1) {
                                // start add book
                                case 1: {
                                    System.out.print("Enter book name: ");
                                    String bookName = sc.nextLine();
                                    System.out.print("Enter author: ");
                                    String author = sc.nextLine();
                                    System.out.print("Enter quantity: ");
                                    int quantity = Integer.parseInt(sc.nextLine());

                                    //add book
                                    BookApplication.addBook(new Book(idBook++, bookName, author, quantity));
                                }
                                break;
                                // end add book

                                // start update book
                                case 2: {
                                    System.out.print("Enter book's id: ");
                                    int id = Integer.parseInt(sc.nextLine());
                                    System.out.print("Enter book name: ");
                                    String bookName = sc.nextLine();
                                    System.out.print("Enter author: ");
                                    String author = sc.nextLine();
                                    System.out.print("Enter quantity: ");
                                    int quantity = Integer.parseInt(sc.nextLine());

                                    //update book
                                    BookApplication.updateBook(id, bookName, author, quantity);
                                }
                                break;
                                // end update book

                                // start remove book
                                case 3: {
                                    System.out.print("Enter book's id: ");
                                    int id = Integer.parseInt(sc.nextLine());

                                    // remove book
                                    BookApplication.removeBook(id);
                                }
                                break;
                                // end remove book

                                default:
                                    System.out.println("-----Out menu 1-----");
                                    choice1 = 4;
                            }
                        } while (choice1 != 4);
                    }
                    break;
                    // end view list book

                    //start view list borrower
                    case 2: {
                        //choice for sub menu 2
                        int choice2 = 0;
                        do {
                            //show list borrower before show sub menu 2
                            System.out.println("--------------------------------------");
                            System.out.println("List borrower:");
                            borrowerApplication.viewAllBorrower();
                            getSubMenu2();

                            choice2 = Integer.parseInt(sc.nextLine());
                            switch (choice2) {
                                // start add infor borrower
                                case 1: {
                                    System.out.print("Enter borrower's name: ");
                                    String borrowerName = sc.nextLine();
                                    System.out.print("Enter age: ");
                                    int age = Integer.parseInt(sc.nextLine());
                                    //validate age of borrower must > 16
                                    if (age > 16) {
                                        System.out.print("Enter book's id: ");
                                        Book book = BookApplication.getBookById(Integer.parseInt(sc.nextLine()));
                                        //validate
                                        if (book != null) {
                                            System.out.print("Enter quantity: ");
                                            int quantity = Integer.parseInt(sc.nextLine());
                                            if (quantity <= book.getQuantity()) {
                                                borrowerApplication.addBorrower(new Borrower(idBorrower++, borrowerName, age,
                                                        LocalDateTime.now(), LocalDateTime.now().plusDays(2),
                                                        book.getId(), book.getBookName(), quantity));

                                                book.setQuantity(book.getQuantity() - quantity);
                                            } else {
                                                System.out.println("-----Book not enough!-----");
                                            }
                                        } else {
                                            System.out.println("-----Book not found!-----");
                                        }
                                    } else {
                                        System.out.println("-----Age must grater than 16!-----");
                                    }

                                }
                                break;
                                // end add infor borrower

                                // start update infor borrower
                                case 2: {
                                    //System.out.println("case 2");
                                    System.out.print("Enter borrower's id: ");
                                    Borrower borrower = borrowerApplication.getBorrowerById(Integer.parseInt(sc.nextLine()));
                                    if (borrower != null) {
                                        System.out.print("Enter borrower's name: ");
                                        String borrowerName = sc.nextLine();
                                        System.out.print("Enter age: ");
                                        int age = Integer.parseInt(sc.nextLine());
                                        if (age > 16) {

                                            // id book must match, return date after now, quantity <= borrow quantity
                                            System.out.print("Enter book's id: ");
                                            Book book = BookApplication.getBookById(Integer.parseInt(sc.nextLine()));
                                            if (book != null) {
                                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                                                System.out.print("Enter return date: ");
                                                LocalDateTime returnDate = LocalDateTime.parse(sc.nextLine(), formatter);
                                                if (returnDate.isAfter(LocalDateTime.now())) {
//                                            System.out.println("Enter book's name: ");
//                                            String bookName = sc.nextLine();
                                                    System.out.print("Enter quantity: ");
                                                    int quantity = Integer.parseInt(sc.nextLine());

                                                    if (quantity <= borrower.getQuantity()) {
                                                        int quantityContain = borrower.getQuantity() - quantity;
                                                        if (quantityContain == 0) {
                                                            borrowerApplication.updateBorrower(borrower.getId(), borrowerName, age,
                                                                    returnDate, book.getId(), quantityContain, true);
                                                            book.setQuantity(book.getQuantity() + quantity);
                                                        } else {
                                                            borrowerApplication.updateBorrower(borrower.getId(), borrowerName, age,
                                                                    returnDate, book.getId(), quantityContain, false);
                                                            book.setQuantity(book.getQuantity() + quantity);
                                                        }
                                                    } else {
                                                        System.out.println("-----Quantity is over!-----");
                                                    }
                                                } else {
                                                    System.out.println("-----Return Date was in the passed!-----");
                                                }
                                            } else {
                                                System.out.println("-----Book not found!-----");
                                            }
                                        } else {
                                            System.out.println("-----Age must over 16!-----");
                                        }
                                    } else {
                                        System.out.println("-----Borrower not found!-----");
                                    }
                                }
                                break;
                                // end update infor borrower

                                default:
                                    System.out.println("Out menu 2");
                                    choice2 = 3;
                            }
                        } while (choice2 != 3);
                    }
                    break;
                    // end view list borrrower

                    case 3:
                        System.out.println("-----Good bye, see you again!-----");
                        break;
                    default:
                        System.out.println("-----The application not support your choice!-----");
                }
            } catch (NumberFormatException e) {
                System.out.println("-----Having error occur!-----");
            } catch (Exception ex) {
                System.out.println("-----Having error exception occur!-----");
            }

        } while (choice != 3);
    }

    public static void getMenu() {
        System.out.println("--------------------------------------");
        System.out.println("1: View list all books");
        System.out.println("2: View list borrower");
        System.out.println("3: Cancel and out");
        System.out.print("Enter your choice: ");
    }

    public static void getSubMenu1() {
        System.out.println("--------------------------------------");
        System.out.println("1: Add book");
        System.out.println("2: Update book");
        System.out.println("3: Remove book");
        System.out.println("Another to cancel");
        System.out.print("Enter your choice: ");
    }

    public static void getSubMenu2() {
        System.out.println("--------------------------------------");
        System.out.println("1: Add borrower information");
        System.out.println("2: Update borrower information");
        System.out.println("Another to cancel");
        System.out.print("Enter your choice: ");
    }
}