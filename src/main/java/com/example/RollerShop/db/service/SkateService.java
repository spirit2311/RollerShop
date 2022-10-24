package com.example.RollerShop.db.service;

import com.example.RollerShop.db.entity.Skate;

import java.util.List;
import java.util.Optional;

public interface SkateService {
    Skate getSkateById(Integer id);

//    List<Skate> getSkateByBrand(String brand);
//    List<Skate> getSkateByDiscipline(String discipline);
//
//    List<SkateDto> getSortSkateAsc();
//
//    List<Skate> getSortSkateDesc();
//
//    List<Skate> getSortRangePrice(Integer startPrice, Integer finishPrice);
//    List<Skate> getAllSkates();
    List<Skate> getAllSkates(String brand, String discipline, Optional<String> sortDirection, Integer priceFrom, Integer priceTo);

    Skate saveSkate(Skate skateData);

    Skate updateSkate(Skate newSkateData);

    void deleteSkate(Integer id);
}
