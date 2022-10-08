package com.example.RollerShop.db.service;

import com.example.RollerShop.db.repository.SkateRepository;
import com.example.RollerShop.db.entity.Skate;
import com.example.RollerShop.db.exception.AccountNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkateServiceImp implements SkateService{

    private SkateRepository skateDao;

    @Autowired
    public SkateServiceImp (SkateRepository skateDao){
        this.skateDao = skateDao;
    }

    @Override
    public Skate getSkateById(Integer id) {
        return skateDao.findById(id).orElseThrow(()-> new AccountNotFoundException(id));
    }
}
