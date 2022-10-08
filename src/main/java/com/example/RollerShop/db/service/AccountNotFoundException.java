package com.example.RollerShop.db.service;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(Integer id) {
        super(String.format("Account id %s NOT FOUND", id));
    }
}
