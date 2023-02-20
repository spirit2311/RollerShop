package com.example.rollerShop.db.service.impl;

import com.example.rollerShop.db.dtoEnity.DisciplineDto;
import com.example.rollerShop.db.entity.Discipline;
import com.example.rollerShop.db.entity.User;
import com.example.rollerShop.db.repository.DisciplineRepository;
import com.example.rollerShop.db.service.DisciplineService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DisciplineServiceImp implements DisciplineService {

    private final DisciplineRepository disciplineRepository;


    @Override
    public List<Discipline> getDisciplineByUuid(UUID uuid) {
        return disciplineRepository.findByUuid(uuid)
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public List<Discipline> getAllDiscipline() {

        return disciplineRepository.findAll();
    }

    @Override
    public Discipline saveDiscipline(DisciplineDto disciplineData) {
        Discipline discipline = new Discipline();
        BeanUtils.copyProperties(disciplineData, discipline);
        return disciplineRepository.save(discipline);
    }

    @Override
    public Discipline updateDiscipline(DisciplineDto newDisciplineData) {
        Discipline discipline = new Discipline();
        BeanUtils.copyProperties(newDisciplineData, discipline);
        return disciplineRepository.save(discipline);
    }

    @Override
    public void deleteDiscipline(UUID uuid) {
        disciplineRepository.deleteByUuid(uuid);
    }
}
