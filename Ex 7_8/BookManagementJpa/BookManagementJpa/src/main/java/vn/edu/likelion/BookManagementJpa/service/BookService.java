package vn.edu.likelion.BookManagementJpa.service;

import vn.edu.likelion.BookManagementJpa.entity.BookEntity;
import vn.edu.likelion.BookManagementJpa.model.SellReportDTO;

import java.util.Date;
import java.util.List;

public interface BookService extends BaseCRUD<BookEntity> {
    String sellBook(int id, int quantity);

    Iterable<BookEntity> sortByPrice();

    Iterable<BookEntity> sortBySellQuantity();

    List<SellReportDTO> sellReport();

    BookEntity searchBook(int id, String title);

    List<BookEntity> searchBookInDateRange(Date startDate, Date endDate);

    List<BookEntity> getTop5BestSeller();

    List<BookEntity> paginate(int page, int size);
}
