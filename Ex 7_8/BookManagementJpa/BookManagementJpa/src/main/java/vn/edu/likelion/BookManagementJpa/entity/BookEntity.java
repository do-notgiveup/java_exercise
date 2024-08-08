package vn.edu.likelion.BookManagementJpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "tbl_book")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Date inputDate;

    @Column
    private int sellQuantity;

    @Column(nullable = true, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Column(nullable = true, insertable = false)
    @LastModifiedDate
    private Date modifiedDate;

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", inputDate=" + inputDate +
                ", sellQuantity=" + sellQuantity +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
