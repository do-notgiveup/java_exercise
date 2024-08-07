package vn.edu.likelion.Warehouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateWarehouseModel {
    private int id;
    private String name;
    private String location;

}
