package vn.edu.likelion.Warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.Warehouse.entity.UserEntity;
import vn.edu.likelion.Warehouse.entity.WarehouseEntity;

import java.util.Optional;

@Repository
public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Integer> {
    WarehouseEntity findByUserId(UserEntity userId);
}
