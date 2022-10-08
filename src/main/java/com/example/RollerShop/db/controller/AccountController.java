package com.example.RollerShop.db.controller;

import com.example.RollerShop.db.entity.Skate;
import com.example.RollerShop.db.repository.SkateRepository;
import com.example.RollerShop.db.service.SkateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/skates")
@RequiredArgsConstructor
public class AccountController {

private final SkateRepository skateRepository;
    public final SkateService skateService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(skateService.getSkateById(id));
    }
    @GetMapping(path="/all")
    public @ResponseBody List<Skate> getAllUsers() {
        return  skateRepository.findAll();
    }

    //POST
    @PostMapping(path="/add")
    public @ResponseBody String addNewSkate (@RequestParam Integer id
            , @RequestParam String brand
            , @RequestParam String model
            , @RequestParam String discipline
            , @RequestParam Integer price
            , @RequestParam String description) {

        Skate n = new Skate();
        n.setId(id);
        n.setBrand(brand);
        n.setModel(model);
        n.setDiscipline(discipline);
        n.setPrice(price);
        n.setDescription(description);
        skateRepository.save(n);
        return "Saved";
    }
    //PUT

    //DELETE
}
