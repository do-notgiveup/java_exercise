package vn.edu.likelion.Warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.Warehouse.entity.WarehouseEntity;
import vn.edu.likelion.Warehouse.model.UpdateWarehouseModel;
import vn.edu.likelion.Warehouse.service.WarehouseService;

import java.util.Iterator;
import java.util.Optional;

@Controller
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    public WarehouseEntity add(WarehouseEntity warehouse) {
        return warehouseService.create(warehouse);
    }

    public WarehouseEntity update(UpdateWarehouseModel model) {
        Optional<WarehouseEntity> warehouse = warehouseService.findById(model.getId());
        warehouse.get().setName(model.getName());
        warehouse.get().setLocation(model.getLocation());
        return warehouseService.update(warehouse.get());
    }

    public Iterator<WarehouseEntity> getAll() {
        return warehouseService.findAll();
    }

    public void delete(int id) {
        WarehouseEntity warehouse = new WarehouseEntity();
        warehouse.setId(id);
        warehouseService.delete(warehouse);
        System.out.println("Delete successful");
    }

    public WarehouseEntity assignUser(int warehouseId, int userId) {
        return warehouseService.assignUser(warehouseId, userId);
    }

    public WarehouseEntity findById(int id) {
        return warehouseService.findById(id).get();
    }

    public int findByUser(int userId) {
        return warehouseService.findByUser(userId);
    }
}
