package com.example.RollerShop.db.service;

import com.example.RollerShop.db.entity.Skate;

import java.util.List;

public interface SkateService {
    Skate getSkateById(Integer id);

    List<Skate> getSkateByBrand(String brand);
    List<Skate> getSkateByDiscipline(String discipline);

    List<Skate> getSortSkateAsc();

    List<Skate> getSortSkateDesc();

    List<Skate> getSortRangePrice(Integer startPrice, Integer finishPrice);

    List<Skate> getAllSkate();

    Skate saveSkate(Skate skateData);

    Skate updateSkate(Skate newSkateData);

    void deleteSkate(Integer id);
}
