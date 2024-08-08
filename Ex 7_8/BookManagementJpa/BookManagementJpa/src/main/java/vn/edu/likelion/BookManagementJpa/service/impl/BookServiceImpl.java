package vn.edu.likelion.BookManagementJpa.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.BookManagementJpa.entity.BookEntity;
import vn.edu.likelion.BookManagementJpa.model.SellReportDTO;
import vn.edu.likelion.BookManagementJpa.repository.BookRepository;
import vn.edu.likelion.BookManagementJpa.service.BookService;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookEntity create(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    @Override
    public BookEntity update(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    @Override
    public void delete(BookEntity bookEntity) {
        bookRepository.delete(bookEntity);
    }

    @Override
    public Iterator<BookEntity> findAll() {
        return bookRepository.findAll().iterator();
    }

    @Override
    public Optional<BookEntity> findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public String sellBook(int bookId, int quantity) {
        BookEntity bookEntity = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        if (quantity <= bookEntity.getQuantity()) {
            bookEntity.setQuantity(bookEntity.getQuantity() - quantity);
            bookEntity.setSellQuantity(bookEntity.getSellQuantity() + quantity);
            bookRepository.save(bookEntity);
        } else {
            return "Book exceeds quantity";
        }
        return "Sell Successful";
    }

    @Override
    public List<BookEntity> sortByPrice() {
        List<BookEntity> list = bookRepository.findAll();
        list.sort((b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice()));
//        list.sort(Comparator.comparingDouble(BookEntity::getPrice));
        return list;
    }

    @Override
    public List<BookEntity> sortBySellQuantity() {
        List<BookEntity> list = bookRepository.findAll();
        list.sort(Comparator.comparingInt(BookEntity::getSellQuantity));
        return list;
    }

    @Override
    public List<SellReportDTO> sellReport() {
        List<BookEntity> list = bookRepository.findAll();
        List<SellReportDTO> list2 = new ArrayList<>();
        for (BookEntity book : list) {
//            list2.add(new SellReportDTO(book.getId(), book.getTitle(), book.getSellQuantity()));
            list2.add(modelMapper.map(book, SellReportDTO.class));
        }
        return list2;
    }

    @Override
    public BookEntity searchBook(int id, String title) {
        return bookRepository.findByIdOrTitle(id, title);
    }

    @Override
    public List<BookEntity> searchBookInDateRange(Date startDate, Date endDate) {
        List<BookEntity> list = bookRepository.findAll();
        List<BookEntity> list2 = new ArrayList<>();
        for (BookEntity book : list) {
            if (book.getInputDate().after(startDate) && book.getInputDate().before(endDate)) {
                list2.add(book);
            }
        }
        return list2;
    }

    @Override
    public List<BookEntity> getTop5BestSeller() {
        List<BookEntity> list = sortBySellQuantity();
        List<BookEntity> list2 = new ArrayList<>();
        int size = list.size();
        if (size > 5) {
            size = 5;
        }
        for (int i = 0; i < size; i++) {
            list2.add(list.get(i));
        }
        return list2;
    }

    @Override
    public List<BookEntity> paginate(int page, int size){
        return bookRepository.paginate(page, size);
    }
}
