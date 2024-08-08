package vn.edu.likelion.BookManagementJpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private String title;
    private double price;
    private int quantity;
    private Date inputDate;
    private int sellQuantity;
}
