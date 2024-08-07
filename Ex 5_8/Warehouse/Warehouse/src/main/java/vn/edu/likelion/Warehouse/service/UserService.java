package vn.edu.likelion.Warehouse.service;

import vn.edu.likelion.Warehouse.entity.UserEntity;

public interface UserService extends BaseCRUD<UserEntity>{
    UserEntity findByUsername(String username);
}
