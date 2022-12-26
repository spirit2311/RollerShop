package com.example.rollerShop.db.entity;

import java.util.Set;

public class User extends BaseEntity{

    private String email;
    private String phoneNumber;

    private Set<Order> orders;


}
