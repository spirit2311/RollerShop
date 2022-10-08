package com.example.RollerShop.db.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(Integer id) {
        super(String.format("Account id %s NOT FOUND", id));
    }
}