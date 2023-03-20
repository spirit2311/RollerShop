package com.example.rollerShop.db.controller;

import com.example.rollerShop.db.dto.SkateDto;
import com.example.rollerShop.db.service.SkateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping(path = "/skates")
@RequiredArgsConstructor
public class SkateController {

    //    private final SkateRepository skateRepository;

    public final SkateService skateService;
//    private final SkateMapper skateMapper;

    @GetMapping(value = "/{id}")
    public List<SkateDto> getSkateById(@PathVariable("id") UUID uuid) {
        return skateService.getSkateByUuid(uuid);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<?> getAllSkates(
            @RequestParam(value = "brand", defaultValue = "") String brand,
            @RequestParam(value = "discipline", defaultValue = "") String discipline,
            @RequestParam(value = "year", defaultValue = "") Integer year,
            @RequestParam(value = "sortYear", defaultValue = "asc") String sortYear,
            @RequestParam(value = "sort", defaultValue = "asc") String sortDirection,
            @RequestParam(value = "priceFrom", defaultValue = "0") Integer startPrice,
            @RequestParam(value = "priceTo", defaultValue = "10000") Integer finishPrice) {
        return ResponseEntity.ok(skateService.getAllSkates(brand, discipline, year, sortYear, sortDirection, startPrice, finishPrice));
    }

    @GetMapping(path = "/search")
    public ResponseEntity<?> getSearchBrandAndModel(
            @RequestParam("value") String search) {
        return ResponseEntity.ok(skateService.getRollerSkateModelAndBrand(search));
    }


    //POST
    @PostMapping()
    public ResponseEntity<?> addSkate(@RequestBody @Valid SkateDto skateDto) {
        skateService.saveSkate(skateDto);
        return ResponseEntity.accepted().build();
    }

    //PUT
    @PutMapping("/{uuid}")
    public ResponseEntity<?> updateSkate(@PathVariable("uuid") UUID uuid,
                                         @RequestBody SkateDto updateSkateDtoData) {
        skateService.updateSkate(uuid, updateSkateDtoData);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteSkate(@PathVariable("uuid") UUID skateUuid) {
        skateService.deleteSkate(skateUuid);
        return new ResponseEntity<String>("Skate deleted successfully!.", HttpStatus.OK);

    }
}
