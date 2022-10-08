package com.example.RollerShop.db.service;

import com.example.RollerShop.db.dao.SkateDao;
import com.example.RollerShop.db.entity.Skate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class SkateServiceImp implements SkateService{

    private SkateDao skateDao;

//    @Autowired
//    public SkateServiceImp (SkateDao skateDao){
//        this.skateDao = skateDao;
//    }
    @Override
    public Skate getSkateById(Integer id) {
        return skateDao.findById(id).orElseThrow(()-> new AccountNotFoundException(id));
    }

    @Override
    public List<Skate> listSkates() {
        return null;
    }
}
