package vn.edu.likelion.librarymanagement.Applications;

import vn.edu.likelion.librarymanagement.Entities.Borrower;
import vn.edu.likelion.librarymanagement.Interfaces.IBorrowerInterface;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class BorrowerApplication implements IBorrowerInterface {
    ArrayList<Borrower> listBorrower = new ArrayList<Borrower>();

    @Override
    public void viewAllBorrower() {
//        Collections.sort(listBorrower, new Comparator<Borrower>() {
//            @Override
//            public int compare(Borrower o1, Borrower o2) {
//                return o1.getBorrowerName().compareTo(o2.getBorrowerName()) &
//                        (o1.getBorrowedDate().compareTo(o2.getBorrowedDate()));
//            }
//        });

        listBorrower.sort(Comparator.comparing(Borrower::getBorrowerName).thenComparing(Borrower::getBorrowedDate));
        for (Borrower borrower : listBorrower) {
            System.out.println(borrower);
        }
    }

    @Override
    public void addBorrower(Borrower b) {
        try {
            listBorrower.add(b);
            System.out.println("-----Add borrower successful!!!-----");

        } catch (Exception e) {
            System.out.println("-----Add fail!-----");
        }
    }

    @Override
    public void updateBorrower(int idBr, String borrowerName, int age, LocalDateTime returnDate,
                               int idBk, int quantity, boolean isReturn) {
        try {
            Borrower borrower = getBorrowerById(idBr);
            if (borrower != null) {
                if (borrower.getIdBook() == idBk) {
                    borrower.setBorrowerName(borrowerName);
                    borrower.setAge(age);
                    borrower.setReturnDate(returnDate);
                    //borrower.setBookName(bookName);
                    borrower.setQuantity(quantity);
                    borrower.setReturn(isReturn);
                    System.out.println("-----Update borrower successful!!!-----");
                } else {
                    System.out.println("-----Book's id is not match!-----");
                }
            } else System.out.println("-----Borrower not found!-----");

        } catch (Exception e) {
            System.out.println("-----Update fail!-----");
        }
    }

    @Override
    public Borrower getBorrowerById(int id) {
        for (Borrower borrower : listBorrower) {
            if (borrower.getId() == id)
                return borrower;
        }
        return null;
    }
}
