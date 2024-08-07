package vn.edu.likelion.Warehouse.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "warehouses")
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WarehouseEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(unique = true)
    private String name;

    @Column
    private String location;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "user_id")
    private UserEntity userId;

    @Override
    public String toString() {
        return "WarehouseEntity{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", userId=" + userId +
                '}';
    }
}