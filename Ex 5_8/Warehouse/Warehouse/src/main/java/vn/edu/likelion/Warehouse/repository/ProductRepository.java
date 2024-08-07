package vn.edu.likelion.Warehouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.Warehouse.entity.ProductEntity;
import vn.edu.likelion.Warehouse.entity.WarehouseEntity;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    ProductEntity getByWarehouseId(WarehouseEntity warehouseId);

    List<ProductEntity> getAllByWarehouseId(WarehouseEntity warehouseId);
}
