package vn.edu.likelion.BookManagementJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.BookManagementJpa.entity.BookEntity;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    BookEntity findByIdOrTitle(int id, String title);

    @Query(value = "SELECT * FROM BOOKS ORDER BY ID OFFSET ?1 ROWS FETCH NEXT ?2 ROWS ONLY;", nativeQuery = true)
    List<BookEntity> paginate(int page, int size);
}
