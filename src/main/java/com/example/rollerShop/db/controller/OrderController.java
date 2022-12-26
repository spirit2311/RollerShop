package com.example.rollerShop.db.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

//    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable String id){
        return null;
    }

    //getorderS by userId

    //getorders by userPhone number

}
