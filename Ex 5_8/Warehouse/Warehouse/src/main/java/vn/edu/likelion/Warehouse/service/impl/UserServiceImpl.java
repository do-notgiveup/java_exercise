package vn.edu.likelion.Warehouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.Warehouse.entity.UserEntity;
import vn.edu.likelion.Warehouse.repository.UserRepository;
import vn.edu.likelion.Warehouse.service.UserService;
import vn.edu.likelion.Warehouse.service.WarehouseService;

import java.util.Iterator;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WarehouseService warehouseService;

    @Override
    public UserEntity create(UserEntity user) {
            return userRepository.save(user);
    }

    @Override
    public UserEntity update(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(UserEntity user) {
        int warehouseId = warehouseService.findByUser(user.getId());
        if (warehouseId > 0) {
            warehouseService.delete(warehouseService.findById(warehouseId).get());
        }

        userRepository.delete(user);
    }

    @Override
    public Iterator<UserEntity> findAll() {
        return userRepository.findAll().iterator();
    }

    @Override
    public Optional<UserEntity> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
