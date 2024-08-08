package vn.edu.likelion.BookManagementJpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.BookManagementJpa.entity.BookEntity;
import vn.edu.likelion.BookManagementJpa.model.BookDTO;
import vn.edu.likelion.BookManagementJpa.model.SellReportDTO;
import vn.edu.likelion.BookManagementJpa.repository.BookRepository;
import vn.edu.likelion.BookManagementJpa.service.BookService;

import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/auth/user/book")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Iterator<BookEntity> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookEntity getBookById(@PathVariable int id) {
        return bookService.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @PostMapping
    public BookEntity createBook(@RequestBody BookDTO book) {
        BookEntity bookEntity = BookEntity.builder()
                .title(book.getTitle())
                .price(book.getPrice())
                .quantity(book.getQuantity())
                .inputDate(book.getInputDate())
                .build();
        return bookService.create(bookEntity);
    }

    @PutMapping
    public BookEntity updateBook(@RequestParam int id, @RequestBody BookDTO book) {
        BookEntity bookEntity = bookService.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        bookEntity.setTitle(book.getTitle());
        bookEntity.setPrice(book.getPrice());
        bookEntity.setQuantity(book.getQuantity());
        bookEntity.setInputDate(book.getInputDate());
        return bookService.update(bookEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.delete(BookEntity.builder().id(id).build());
    }

    @PutMapping("/sellBook")
    public String sellBook(@RequestParam int id, @RequestParam int quantity) {
        return bookService.sellBook(id, quantity);
    }

    @GetMapping("/sortByType/{type}")
    public List<BookEntity> sortByPrice(@PathVariable String type) {
        if (type.equals("price")) {
            return StreamSupport.stream(bookService.sortByPrice().spliterator(), false)
                    .collect(Collectors.toList());
        } else if (type.equals("sell")) {
            return StreamSupport.stream(bookService.sortBySellQuantity().spliterator(), false)
                    .collect(Collectors.toList());
        }
        return null;
    }

    @GetMapping("/sellReport")
    public List<SellReportDTO> sellReport() {
        return bookService.sellReport();
    }

    @GetMapping("/searchBook")
    public BookEntity searchBook(@RequestParam(value = "id", defaultValue = "0") int id, @RequestParam String title) {
        return bookService.searchBook(id, title);
    }

    @GetMapping("/searchInDateRange")
    public List<BookEntity> searchBookInDateRange(@RequestParam("startDate")
                                                  @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                  @RequestParam
                                                  @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return bookService.searchBookInDateRange(startDate, endDate);
    }

    @GetMapping("/getTop5BestSeller")
    public List<BookEntity> getTop5BestSeller(){
        return bookService.getTop5BestSeller();
    }

    @GetMapping("/paginate")
    public List<BookEntity> paginate(@RequestParam int page, @RequestParam int size) {
       return bookService.paginate(page, size);
    }
}
