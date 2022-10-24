package com.example.rollerShop.db.exception;

public class SkateNotFoundException extends RuntimeException {

    public SkateNotFoundException(Integer id) {
        super(String.format("Account id %s NOT FOUND", id));
    }
}
