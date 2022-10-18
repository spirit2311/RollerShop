package com.example.RollerShop.db.service;

import com.example.RollerShop.db.entity.Skate;

import java.util.List;

public interface SkateService {
    Skate getSkateById(Integer id);

    List<Skate> getAllSkate();

    String saveSkate(Skate skateData);

    String updateSkate(Skate newSkateData);

    void deleteSkate(Integer id);
}
