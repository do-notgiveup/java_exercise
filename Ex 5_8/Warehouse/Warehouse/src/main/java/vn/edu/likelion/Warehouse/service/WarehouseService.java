package vn.edu.likelion.Warehouse.service;

import org.springframework.http.ResponseEntity;
import vn.edu.likelion.Warehouse.entity.WarehouseEntity;

public interface WarehouseService extends BaseCRUD<WarehouseEntity> {
    WarehouseEntity assignUser(int warehouseId, int userId);

    int findByUser(int userId);
}
