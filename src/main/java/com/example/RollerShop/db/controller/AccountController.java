package com.example.RollerShop.db.controller;

import com.example.RollerShop.db.service.SkateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/skates")
@RequiredArgsConstructor
public class AccountController {


    public final SkateService skateService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(skateService.getSkateById(id));
    }



    //POST

    //PUT

    //DELETE
}
