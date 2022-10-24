package com.example.rollerShop.db.service;

import com.example.rollerShop.db.dtoEnity.SkateDto;
import com.example.rollerShop.db.entity.Skate;

import java.util.List;

public interface SkateService {
    List<SkateDto> getSkateById(Integer id);

    List<SkateDto> getAllSkates(String brand, String discipline, String sortDirection, Integer priceFrom, Integer priceTo);

    Skate saveSkate(Skate skateData);

    Skate updateSkate(Skate newSkateData);

    void deleteSkate(Integer id);
}
