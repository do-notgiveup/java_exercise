package vn.edu.likelion.librarymanagement.Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Borrower {
    private int id;
    private String borrowerName;
    private int age;
    private LocalDateTime borrowedDate;
    private LocalDateTime returnDate;
    private int idBook;
    private String bookName;
    private int quantity;
    private boolean isReturn = false;

    public Borrower() {
    }

    public Borrower(int id, String borrowerName, int age, LocalDateTime borrowedDate, LocalDateTime returnDate,
                    int idBook, String bookName, int quantity) {
        this.id = id;
        this.borrowerName = borrowerName;
        this.age = age;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.idBook = idBook;
        this.bookName = bookName;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDateTime borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturn() {
        return isReturn;
    }

    public void setReturn(boolean aReturn) {
        isReturn = aReturn;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Borrower{" +
                "id=" + id +
                ", borrowerName='" + borrowerName + '\'' +
                ", age=" + age +
                ", borrowedDate=" + borrowedDate.format(formatter) +
                ", returnDate=" + returnDate.format(formatter) +
                ", idBook=" + idBook +
                ", bookName='" + bookName + '\'' +
                ", quantity=" + quantity +
                ", isReturn=" + (isReturn ? "Returned" : "Not returned yet") +
                '}';
    }
}
