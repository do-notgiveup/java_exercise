package vn.edu.likelion.Warehouse.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "Products")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private double price;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "warehouse_id")
    private WarehouseEntity warehouseId;

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", warehouseId=" + warehouseId +
                '}';
    }
}
