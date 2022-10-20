package com.example.RollerShop.db.service;

import com.example.RollerShop.db.repository.SkateRepository;
import com.example.RollerShop.db.entity.Skate;
import com.example.RollerShop.db.exception.SkateNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkateServiceImp implements SkateService {

    private SkateRepository skateRepository;

    @Autowired
    public SkateServiceImp(SkateRepository skateDao) {
        this.skateRepository = skateDao;
    }

    @Override
    public Skate getSkateById(Integer id) {
        return skateRepository.findById(id).orElseThrow(() -> new SkateNotFoundException(id));
    }

    @Override
    public List<Skate> getSkateByBrand(String brand) {
        return skateRepository.findByBrand(brand);
    }

    @Override
    public List<Skate> getSkateByDiscipline(String discipline) {
        return skateRepository.findByDiscipline(discipline);
    }

    @Override
    public List<Skate> getSortSkateAsc() {
        return skateRepository.sortByPriceAsc();
    }

    @Override
    public List<Skate> getSortSkateDesc() {
        return skateRepository.sortByPriceDesc();
    }

    @Override
    public List<Skate> getSortRangePrice(Integer startPrice, Integer finishPrice) {
        return skateRepository.sortByRangePrice(startPrice,finishPrice);
    }

    @Override
    public List<Skate> getAllSkate() {
        return skateRepository.findAll();
    }

    @Override
    public Skate saveSkate(Skate skateData) {
        return  skateRepository.save(skateData);
    }

    @Override
    public Skate updateSkate(Skate newSkateData) {
        return skateRepository.save(newSkateData);
    }

    @Override
    public void deleteSkate(Integer id) {
        skateRepository.deleteById(id);
    }
}
