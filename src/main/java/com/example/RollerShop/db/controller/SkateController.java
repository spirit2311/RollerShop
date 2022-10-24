package com.example.RollerShop.db.controller;

import com.example.RollerShop.db.entity.Skate;
import com.example.RollerShop.db.repository.SkateRepository;
import com.example.RollerShop.db.service.SkateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/skates")
@RequiredArgsConstructor
public class SkateController {

    //TODO change getmapping all to one and use @RequestParam

private final SkateRepository skateRepository;
    public final SkateService skateService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(skateService.getSkateById(id));
    }
    @GetMapping(path="/all")
    public @ResponseBody List<Skate> getAllUsers() {
        return  skateService.getAllSkate();
    }


    //POST
    @PostMapping()
    public Skate addSkate(@RequestBody Skate skateData) {
        return skateService.saveSkate(skateData);
    }

    //PUT
    @PutMapping()
    public Skate updateUser(@RequestBody Skate newSkaterData) {
        return skateService.updateSkate(newSkaterData);
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteSkate(@PathVariable("id") Integer skateId){

            skateService.deleteSkate(skateId);

            return new ResponseEntity<String>("Skate deleted successfully!.", HttpStatus.OK);

        }
}
