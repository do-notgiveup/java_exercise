package com.example.demo_spring_security.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Data
public class Account extends EntityDefine implements UserDetails {
    @Column(unique=true, nullable=false)
    private String username;
    @Column(nullable=false, unique=true)
    private String password;
    @ManyToOne
    @JoinColumn(
            name = "role_id",
            nullable = false
    )
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.getRoleName()));
    }
}
