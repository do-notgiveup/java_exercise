package vn.edu.likelion.librarymanagement.Applications;

import vn.edu.likelion.librarymanagement.Entities.Book;
import vn.edu.likelion.librarymanagement.Interfaces.IBookInterface;

import java.util.ArrayList;

public class BookApplication implements IBookInterface {

    ArrayList<Book> listBook = new ArrayList<Book>();

    @Override
    public void viewAllBook() {
        for (Book book : listBook) {
            System.out.println(book.toString());
        }
    }

    @Override
    public void addBook(Book book) {
        try {
            listBook.add(book);
            System.out.println("-----Add book successful!!!-----");

        } catch (Exception e) {
            System.out.println("-----Add fail!-----");
        }
    }

    @Override
    public void updateBook(int id, String bookName, String author, int quantity) {
        try {
            Book book = getBookById(id);
            if (book != null) {
                book.setBookName(bookName);
                book.setAuthor(author);
                book.setQuantity(quantity);
                System.out.println("-----Update book successful!!!-----");
            } else System.out.println("-----Book not found!-----");
        } catch (Exception e) {
            System.out.println("-----Update fail!-----");
        }
    }

    @Override
    public void removeBook(int id) {
        try {
            Book book = getBookById(id);
            if (book != null) {
                listBook.remove(book);
                System.out.println("-----Remove book successful!!!-----");
            } else System.out.println("-----Book not found!-----");
        } catch (Exception e) {
            System.out.println("-----Remove fail!-----");
        }
    }

    @Override
    public Book getBookById(int id) {
        for (Book book : listBook) {
            if (book.getId() == id)
                return book;
        }
        return null;
    }
}
