package vn.edu.likelion.Warehouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.Warehouse.entity.UserEntity;
import vn.edu.likelion.Warehouse.service.AuthService;
import vn.edu.likelion.Warehouse.service.UserService;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserService userService;
    
    @Override
    public UserEntity login(String username, String password) {
        UserEntity userEntity = userService.findByUsername(username);
        if (userEntity == null) {
            return null;
        }
        if (!userEntity.getPassword().equals(password)) {
            return null;
        }
        return userEntity;
    }
}