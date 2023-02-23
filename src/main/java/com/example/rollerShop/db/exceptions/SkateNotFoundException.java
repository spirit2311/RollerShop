package com.example.rollerShop.db.exceptions;

public class SkateNotFoundException extends RuntimeException {

    public SkateNotFoundException(Integer id) {
        super(String.format("Account id %s NOT FOUND", id));
    }
}
