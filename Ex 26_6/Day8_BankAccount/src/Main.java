import vn.edu.likelion.Applications.CurrentAccountApplication;
import vn.edu.likelion.Applications.SavingsAccountApplication;
import vn.edu.likelion.Entities.CurrentAccount;
import vn.edu.likelion.Entities.SavingsAccount;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static SavingsAccountApplication savingsAccountApplication = new SavingsAccountApplication();
    static CurrentAccountApplication currentAccountApplication = new CurrentAccountApplication();

    public static void main(String[] args) {

//        System.out.println("Hello world!");
//        Account savingAccount = new SavingsAccount(new BigDecimal(1000), "0.0125");
//        Account currentAccount = new CurrentAccount(new BigDecimal(5000), new BigDecimal("0.0125"));
//
//        savingAccount.saveMoney(new BigDecimal(100));
//        currentAccount.saveMoney( new BigDecimal(500));
//
//        System.out.println("in ra ne: ");
//        savingAccount.viewMoneyBalance();
//        currentAccount.viewMoneyBalance();

        int choice = 0;
        int idSA = 1;
        int idCA = 1;

        do {
            try {
                showMenu();
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 0: {
                        System.out.println("Exit application, good bye and see you again!");
                    }
                    break;
                    case 1: {
                        doCase1InMenu(idSA);
                    }
                    break;
                    case 2: {
                        doCase2InMenu(idCA);
                    }
                    break;
                    case 3: {
                        System.out.println("------------------------------------------------");
                        System.out.println("1: Saving accout");
                        System.out.println("2:  Current account");
                        System.out.print("Enter your choice: ");
                        switch (Integer.parseInt(sc.nextLine())) {
                            case 1: {
                                System.out.print("Enter saving account id:");
                                int id = Integer.parseInt(sc.nextLine());
                                System.out.print("Enter amout: ");
                                BigDecimal amout = new BigDecimal(sc.nextLine());
                                savingsAccountApplication.getAccount(id).saveMoney(amout);
                            }
                            break;
                            case 2: {
                                System.out.print("Enter current account id:");
                                int id = Integer.parseInt(sc.nextLine());
                                System.out.print("Enter amout: ");
                                BigDecimal amout = new BigDecimal(sc.nextLine());
                                currentAccountApplication.getAccount(id).saveMoney(amout);
                            }
                            break;
                            default:
                                System.out.println("not support!");
                        }

                    }
                    break;
                    case 4: {
                        System.out.println("------------------------------------------------");
                        System.out.println("1: Saving accout");
                        System.out.println("2:  Current account");
                        System.out.print("Enter your choice: ");
                        switch (Integer.parseInt(sc.nextLine())) {
                            case 1: {
                                System.out.print("Enter saving account id:");
                                int id = Integer.parseInt(sc.nextLine());
                                System.out.print("Enter amout: ");
                                BigDecimal amout = new BigDecimal(sc.nextLine());
                                if (savingsAccountApplication.getAccount(id).getInitialDeposit().compareTo(amout) >= 0)
                                    savingsAccountApplication.getAccount(id).withdrawMoney(amout);
                                else System.out.println("not enough balance!");
                            }
                            break;
                            case 2: {
                                System.out.print("Enter current account id:");
                                int id = Integer.parseInt(sc.nextLine());
                                System.out.print("Enter amout: ");
                                BigDecimal amount = new BigDecimal(sc.nextLine());
                                if (currentAccountApplication.getAccount(id).getOverDraftLimit().compareTo(amount) >= 0
                                        && currentAccountApplication.getAccount(id).getInitialDeposit().compareTo(amount) <= 0
                                ) {
                                    currentAccountApplication.getAccount(id).withdrawMoney(amount);
                                }
                                System.out.println("amount to over limit or not enough balance!");
                            }
                            break;
                            default:
                                System.out.println("not support!");
                        }
                    }
                    break;
                    case 5: {
                        System.out.print("Enter saving account id: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter num of year: ");
                        int year = Integer.parseInt(sc.nextLine());
                        savingsAccountApplication.getAccount(id).interest(year);
                    }
                    break;
                    default:
                        System.out.println("Application haven't support your choice!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("------------------------------------------------");
        System.out.println("0: Exit Application");
        System.out.println("1: Manage Savings Account");
        System.out.println("2: Manage Current Account");
        System.out.println("3: Save money");
        System.out.println("4: Draft money");
        System.out.println("5: Interest money");
        System.out.print("Enter your choice: ");
    }

    public static void showMenu1() {
        savingsAccountApplication.getAllAccount();
        System.out.println("------------------------------------------------");
        System.out.println("0: Out menu 1");
        System.out.println("1: Add saving account");
        System.out.println("2: Update saving account");
        System.out.println("3: Remove saving account");
        System.out.print("Enter your choice: ");
    }

    public static void doCase1InMenu(int idSA) {
        int choice1 = 0;
        do {
            showMenu1();
            choice1 = Integer.parseInt(sc.nextLine());
            switch (choice1) {
                case 1: {
                    System.out.print("Enter Initial Deposit: ");
                    BigDecimal initialDeposit = new BigDecimal(sc.nextLine());
                    System.out.print("Enter Interest rate: ");
                    String interest = sc.nextLine();
                    SavingsAccount account = new SavingsAccount(idSA, initialDeposit, interest);
                    savingsAccountApplication.addAccount(account);
                }
                break;
                case 2: {
                    System.out.print("Enter savings account id to update: ");
                    SavingsAccount account = savingsAccountApplication.getAccount(Integer.parseInt(sc.nextLine()));
                    savingsAccountApplication.updateAccount(account);
                }
                break;
                case 3: {
                    System.out.print("Enter savings account id to remove: ");
                    SavingsAccount account = savingsAccountApplication.getAccount(Integer.parseInt(sc.nextLine()));
                    savingsAccountApplication.removeAccount(account);
                }
                break;
                case 0: {
                    System.out.println("Out menu 1");
                }
                break;
                default:
                    System.out.println("Application haven't support your choice!");
            }
        } while (choice1 != 0);
    }

    public static void showMenu2() {
        currentAccountApplication.getAllAccount();
        System.out.println("------------------------------------------------");
        System.out.println("0: Out menu 2");
        System.out.println("1: Add current account");
        System.out.println("2: Update current account");
        System.out.println("3: Remove current account");
        System.out.print("Enter your choice: ");
    }

    public static void doCase2InMenu(int idCA) {
        int choice2 = 0;
        do {
            showMenu2();
            choice2 = Integer.parseInt(sc.nextLine());
            switch (choice2) {
                case 1: {
                    System.out.print("Enter Initial Deposit: ");
                    BigDecimal initialDeposit = new BigDecimal(sc.nextLine());
                    System.out.print("Enter OverdraftLimit: ");
                    BigDecimal interest = new BigDecimal(sc.nextLine());
                    CurrentAccount account = new CurrentAccount(idCA, initialDeposit, interest);
                    currentAccountApplication.addAccount(account);
                }
                break;
                case 2: {
                    System.out.print("Enter current account id to update: ");
                    CurrentAccount account = currentAccountApplication.getAccount(Integer.parseInt(sc.nextLine()));
                    currentAccountApplication.updateAccount(account);
                }
                break;
                case 3: {
                    System.out.print("Enter current account id to remove: ");
                    CurrentAccount account = currentAccountApplication.getAccount(Integer.parseInt(sc.nextLine()));
                    currentAccountApplication.removeAccount(account);
                }
                break;
                case 0: {
                    System.out.println("Out menu 2");
                }
                break;
                default:
                    System.out.println("Application haven't support your choice!");
            }
        } while (choice2 != 0);
    }
}