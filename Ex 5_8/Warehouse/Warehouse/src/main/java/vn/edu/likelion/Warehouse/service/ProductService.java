package vn.edu.likelion.Warehouse.service;

import vn.edu.likelion.Warehouse.entity.ProductEntity;

public interface ProductService extends BaseCRUD<ProductEntity> {
    ProductEntity changeWarehouse(int productId, int warehouseId);
}
