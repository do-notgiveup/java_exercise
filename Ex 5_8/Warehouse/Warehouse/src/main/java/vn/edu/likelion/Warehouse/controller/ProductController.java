package vn.edu.likelion.Warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.Warehouse.entity.ProductEntity;
import vn.edu.likelion.Warehouse.model.UpdateProductModel;
import vn.edu.likelion.Warehouse.service.ProductService;
import vn.edu.likelion.Warehouse.service.WarehouseService;

import java.util.Iterator;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private WarehouseService warehouseService;

    public ProductEntity create(String name,
                                String description,
                                int quantity,
                                double price,
                                int warehouseId) {
        ProductEntity product = new ProductEntity();
        product.setName(name);
        product.setDescription(description);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setWarehouseId(warehouseService.findById(warehouseId).get());
        return productService.create(product);
    }

    public ProductEntity update(UpdateProductModel model) {
        Optional<ProductEntity> product = productService.findById(model.getId());
        product.get().setName(model.getName());
        product.get().setDescription(model.getDescription());
        product.get().setQuantity(model.getQuantity());
        return productService.update(product.get());
    }

    public Iterator<ProductEntity> getAll() {
        return productService.findAll();
    }

    public ResponseEntity<?> delete(int id) {
        Optional<ProductEntity> product = productService.findById(id);
        productService.delete(product.get());
        return ResponseEntity.status(HttpStatus.OK).body("Delete successful");
    }

    public ProductEntity changeWarehouse(int productId, int warehouseId) {
        return productService.changeWarehouse(productId, warehouseId);
    }
}
