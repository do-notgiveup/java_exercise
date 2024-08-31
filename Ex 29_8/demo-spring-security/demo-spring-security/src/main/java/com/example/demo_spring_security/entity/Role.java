package com.example.demo_spring_security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
public class Role extends EntityDefine {
    @Column(nullable = false, unique = true, name = "name")
    private String roleName;
    @OneToMany(mappedBy = "role")
    private Collection<Account> accounts;
}
