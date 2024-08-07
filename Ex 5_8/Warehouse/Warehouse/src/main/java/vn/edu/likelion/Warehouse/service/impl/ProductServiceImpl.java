package vn.edu.likelion.Warehouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.Warehouse.entity.ProductEntity;
import vn.edu.likelion.Warehouse.entity.WarehouseEntity;
import vn.edu.likelion.Warehouse.repository.ProductRepository;
import vn.edu.likelion.Warehouse.repository.WarehouseRepository;
import vn.edu.likelion.Warehouse.service.ProductService;

import java.util.Iterator;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Override
    public ProductEntity create(ProductEntity user) {
        return productRepository.save(user);
    }

    @Override
    public ProductEntity update(ProductEntity user) {
        return productRepository.save(user);
    }

    @Override
    public void delete(ProductEntity user) {
        productRepository.delete(user);
    }

    @Override
    public Iterator<ProductEntity> findAll() {
        return productRepository.findAll().iterator();
    }

    @Override
    public Optional<ProductEntity> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductEntity changeWarehouse(int productId, int warehouseId) {
        Optional<ProductEntity> product = productRepository.findById(productId);

        Optional<WarehouseEntity> warehouse = warehouseRepository.findById(warehouseId);

        product.get().setWarehouseId(warehouse.get());
        return productRepository.save(product.get());
    }
}
