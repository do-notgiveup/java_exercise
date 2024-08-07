package vn.edu.likelion.Warehouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductModel {
    private int id;
    private String name;
    private String description;
    private int quantity;
}
