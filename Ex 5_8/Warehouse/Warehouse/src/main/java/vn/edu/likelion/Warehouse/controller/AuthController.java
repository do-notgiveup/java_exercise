package vn.edu.likelion.Warehouse.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import vn.edu.likelion.Warehouse.WarehouseApplication;
import vn.edu.likelion.Warehouse.entity.UserEntity;
import vn.edu.likelion.Warehouse.service.AuthService;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    public UserEntity login(String username, String password) {
        UserEntity user = authService.login(username, password);
        if (user == null) {
            return null;
        }
        WarehouseApplication.user = user;
        WarehouseApplication.role = user.getRole();
        return user;
    }

    public void logout() {
        WarehouseApplication.user = null;
        WarehouseApplication.role = 0;
    }

}