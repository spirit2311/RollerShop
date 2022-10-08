package com.example.RollerShop.db.service;

import com.example.RollerShop.db.dao.SkateDao;
import com.example.RollerShop.db.entity.Skate;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
