package com.example.rollerShop.db.controller;


import com.example.rollerShop.db.dtoEnity.DisciplineDto;
import com.example.rollerShop.db.entity.Discipline;
import com.example.rollerShop.db.service.DisciplineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/disciplines")
@RequiredArgsConstructor
public class DisciplineController {

    public final DisciplineService disciplineService;

    @GetMapping(value = "/{id}")
    public List<Discipline> getSkateById(@PathVariable("id") UUID uuid) {
        return disciplineService.getDisciplineByUuid(uuid);
    }

    @PostMapping()
    public ResponseEntity<?> addDiscipline(@RequestBody DisciplineDto disciplineData) {
        disciplineService.saveDiscipline(disciplineData);
        return ResponseEntity.accepted().build();
    }

    @PutMapping()
    public ResponseEntity<?> updateDiscipline(@RequestBody DisciplineDto newDisciplineData) {
        disciplineService.updateDiscipline(newDisciplineData);
        return ResponseEntity.accepted().build();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDiscipline(@PathVariable("id") UUID disciplineUuid) {

        disciplineService.deleteDiscipline(disciplineUuid);

        return new ResponseEntity<String>("Discipline deleted successfully!.", HttpStatus.OK);

    }

}
