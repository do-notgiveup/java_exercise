package vn.edu.likelion.librarymanagement.Interfaces;

import vn.edu.likelion.librarymanagement.Entities.Book;

public interface IBookInterface {
    public void viewAllBook();
    public void addBook(Book book);
    public void updateBook(int id, String bookName, String author, int quantity);
    public void removeBook(int id);
    public Book getBookById(int id);
}
