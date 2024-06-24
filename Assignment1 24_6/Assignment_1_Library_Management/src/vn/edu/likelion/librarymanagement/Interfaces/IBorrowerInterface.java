package vn.edu.likelion.librarymanagement.Interfaces;

import vn.edu.likelion.librarymanagement.Entities.Borrower;

import java.time.LocalDateTime;

public interface IBorrowerInterface {
    public void viewAllBorrower();
    public void addBorrower(Borrower borrower);
    public void updateBorrower(int idBr, String borrowerName, int age, LocalDateTime returnDate,
                               int idBk, int quantity, boolean isReturn);
    public Borrower getBorrowerById(int id);
}
