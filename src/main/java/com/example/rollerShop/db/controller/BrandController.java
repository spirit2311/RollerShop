package com.example.rollerShop.db.controller;


import com.example.rollerShop.db.dtoEnity.BrandDto;
import com.example.rollerShop.db.entity.Brand;
import com.example.rollerShop.db.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/brands")
@RequiredArgsConstructor
public class BrandController {

    public final BrandService brandService;

    @GetMapping(value = "/{id}")
    public List<Brand> getSkateById(@PathVariable("id") UUID uuid) {
        return brandService.getBrandByUuid(uuid);
    }

    @PostMapping()
    public ResponseEntity<?> addBrand(@RequestBody BrandDto brandData) {
        brandService.saveBrand(brandData);
        return ResponseEntity.accepted().build();
    }

    @PutMapping()
    public Brand updateBrand(@RequestBody Brand newBrandData) {
        return brandService.updateBrand(newBrandData);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteBrand(@PathVariable("uuid") UUID brandUuid) {

        brandService.deleteBrand(brandUuid);

        return new ResponseEntity<>("Brand deleted successfully!.", HttpStatus.OK);

    }

}
