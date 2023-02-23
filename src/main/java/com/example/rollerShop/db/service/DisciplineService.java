package com.example.rollerShop.db.service;

import com.example.rollerShop.db.dto.DisciplineDto;
import com.example.rollerShop.db.entity.Discipline;

import java.util.List;
import java.util.UUID;

public interface DisciplineService {

    List<Discipline> getDisciplineByUuid(UUID uuid);

    List<Discipline> getAllDisciplines();

    Discipline saveDiscipline(DisciplineDto disciplineData);

    Discipline updateDiscipline(DisciplineDto newDisciplineData);

    void deleteDiscipline(UUID uuid);
}
