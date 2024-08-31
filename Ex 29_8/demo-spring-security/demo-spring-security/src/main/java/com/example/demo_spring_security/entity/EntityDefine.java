package com.example.demo_spring_security.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@MappedSuperclass
public class EntityDefine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "is_deleted")
    @ColumnDefault("0")
    private Boolean isDeleted;
}
