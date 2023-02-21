package com.example.rollerShop.db.service;

import com.example.rollerShop.db.dtoEnity.SkateDto;
import com.example.rollerShop.db.entity.Brand;
import com.example.rollerShop.db.entity.Skate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SkateService {
    List<SkateDto> getSkateByUuid(UUID uuid);

    List<SkateDto> getAllSkates(String brand, String discipline, Integer year, String sortYear, String sortDirection, Integer priceFrom, Integer priceTo);

//    List<SkateDto> searchByBrandAndModel(String brand, String model);

    SkateDto saveSkate(SkateDto skateData);

    void updateSkate(UUID uuid, SkateDto newSkateData);

    void deleteSkate(UUID uuid);
}
