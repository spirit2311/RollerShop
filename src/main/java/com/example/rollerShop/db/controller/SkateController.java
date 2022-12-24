package com.example.rollerShop.db.controller;

import com.example.rollerShop.db.dtoEnity.SkateDto;
import com.example.rollerShop.db.dtoEnity.SkateMapper;
import com.example.rollerShop.db.entity.Skate;
import com.example.rollerShop.db.repository.SkateRepository;
import com.example.rollerShop.db.service.SkateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/skates")
@RequiredArgsConstructor
public class SkateController {

    private final SkateRepository skateRepository;
    public final SkateService skateService;
    private final SkateMapper skateMapper;

    @GetMapping(value = "/{id}")
    public List<SkateDto> getSkateById(@PathVariable("id") Integer id) {
        return skateService.getSkateById(id);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<?> getAllSkates(
            @RequestParam(value = "brand", defaultValue = "") String brand,
            @RequestParam(value = "discipline", defaultValue = "") String discipline,
            @RequestParam(value = "sort", defaultValue = "asc") String sortDirection,
            @RequestParam(value = "priceFrom", defaultValue = "0") Integer startPrice,
            @RequestParam(value = "priceTo", defaultValue = "10000") Integer finishPrice) {
        return ResponseEntity.ok(skateService.getAllSkates(brand, discipline, sortDirection, startPrice, finishPrice));
    }


    //POST
    @PostMapping()
    public ResponseEntity<?> addSkate(@RequestBody SkateDto skateDto) {
        Skate skate  = skateMapper.toSkate(skateDto);
        Skate postCreated = skateService.saveSkate(skate);
        return ResponseEntity.ok(postCreated);
    }

    //PUT
    @PutMapping()
    public ResponseEntity<?> updateSkate(@RequestBody SkateDto newSkateDtoData) {
        Skate skate  = skateMapper.toSkate(newSkateDtoData);
        Skate postCreated = skateService.saveSkate(skate);
        return ResponseEntity.ok(postCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSkate(@PathVariable("id") Integer skateId) {
        skateService.deleteSkate(skateId);
        return new ResponseEntity<String>("Skate deleted successfully!.", HttpStatus.OK);

    }
}
