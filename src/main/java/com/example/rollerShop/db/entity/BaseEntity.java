package com.example.rollerShop.db.entity;

import jakarta.persistence.*;


public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
