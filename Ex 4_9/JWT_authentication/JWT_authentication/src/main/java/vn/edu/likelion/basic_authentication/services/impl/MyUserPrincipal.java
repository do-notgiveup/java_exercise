package vn.edu.likelion.basic_authentication.services.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import vn.edu.likelion.basic_authentication.entities.UserEntity;

import java.util.Collection;
import java.util.List;

public class MyUserPrincipal implements UserDetails {
    private UserEntity user;

    public MyUserPrincipal(UserEntity user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
    //...
}

