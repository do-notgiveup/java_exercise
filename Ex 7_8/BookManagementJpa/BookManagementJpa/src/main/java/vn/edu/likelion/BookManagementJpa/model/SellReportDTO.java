package vn.edu.likelion.BookManagementJpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellReportDTO {
    private int id;
    private String title;
    private int sellQuantity;
}
