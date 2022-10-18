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
    public List<Skate> getAllSkate() {
        return skateRepository.findAll();
    }

    @Override
    public String saveSkate(Skate skateData) {
        skateRepository.save(skateData);
        return "Skate Saved";
    }

    @Override
    public String updateSkate(Skate newSkateData) {
        String msg = null;
        if (newSkateData.getId() != null) {
            skateRepository.save(newSkateData);
            msg = "Data updated";
        } else {
            msg = "Error";
        }

        return msg;
    }

    @Override
    public void deleteSkate(Integer id) {
        skateRepository.deleteById(id);
    }
}
