package vn.edu.likelion.Warehouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.Warehouse.WarehouseApplication;
import vn.edu.likelion.Warehouse.entity.ProductEntity;
import vn.edu.likelion.Warehouse.entity.UserEntity;
import vn.edu.likelion.Warehouse.entity.WarehouseEntity;
import vn.edu.likelion.Warehouse.repository.ProductRepository;
import vn.edu.likelion.Warehouse.repository.UserRepository;
import vn.edu.likelion.Warehouse.repository.WarehouseRepository;
import vn.edu.likelion.Warehouse.service.WarehouseService;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class WarehouseImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public WarehouseEntity create(WarehouseEntity warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @Override
    public WarehouseEntity update(WarehouseEntity warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @Override
    public void delete(WarehouseEntity warehouse) {
        ProductEntity product = productRepository
                .getByWarehouseId(warehouseRepository.findById(warehouse.getId()).get());
        if (product != null) {
            System.out.print("Having product in warehouse, choose other warehouse to change: ");
            int warehouseId = Integer.parseInt(WarehouseApplication.sc.nextLine());
            WarehouseEntity warehouseEntity = warehouseRepository.getById(warehouseId);

            List<ProductEntity> list = productRepository
                    .getAllByWarehouseId(warehouseRepository.findById(warehouse.getId()).get());
            for (ProductEntity productEntity : list) {
                productEntity.setWarehouseId(warehouseEntity);
                productRepository.save(productEntity);
            }

        }
        warehouseRepository.delete(warehouse);
    }

    @Override
    public Iterator<WarehouseEntity> findAll() {
        return warehouseRepository.findAll().iterator();
    }

    @Override
    public Optional<WarehouseEntity> findById(int id) {
        return warehouseRepository.findById(id);
    }

    @Override
    public WarehouseEntity assignUser(int warehouseId, int userId) {
        Optional<UserEntity> user = userRepository.findById(userId);

        Optional<WarehouseEntity> warehouse = warehouseRepository.findById(warehouseId);

        warehouse.get().setUserId(user.get());
        return warehouseRepository.save(warehouse.get());
    }

    @Override
    public int findByUser(int userId) {
        WarehouseEntity warehouse = warehouseRepository.findByUserId(userRepository.findById(userId).get());
        return warehouse.getId();
    }
}
