package vn.edu.likelion.librarymanagement.Entities;

public class Book {
    private int id;
    private String bookName;
    private String author;
    private int quantity;

    public Book(){};

    public Book(int id, String bookName, String author, int quantity) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.quantity = quantity;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
