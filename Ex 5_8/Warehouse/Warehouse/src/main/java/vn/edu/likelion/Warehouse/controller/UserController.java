package vn.edu.likelion.Warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import vn.edu.likelion.Warehouse.entity.UserEntity;
import vn.edu.likelion.Warehouse.service.UserService;

import java.util.Iterator;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public UserEntity createUser( String username,  String password) {
        UserEntity user = new UserEntity();
        user.setFullname(username);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(2);
        return userService.create(user);
    }

    public UserEntity updateUser( String fullname,  int id) {
        Optional<UserEntity> user = userService.findById(id);
        user.get().setFullname(fullname);
        return userService.update(user.get());
    }

    public Iterator<UserEntity> getAllUsers() {
        return userService.findAll();
    }

    public void deleteUser( int id) {
        UserEntity user = new UserEntity();
        user.setId(id);
        userService.delete(user);
        System.out.println("Delete successful");
    }

    public UserEntity getUserById( int id) {
        return userService.findById(id).get();
    }
}
