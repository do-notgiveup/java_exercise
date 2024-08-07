package vn.edu.likelion.Warehouse.service;

import vn.edu.likelion.Warehouse.entity.UserEntity;

public interface AuthService {
    UserEntity login(String username, String password);
}