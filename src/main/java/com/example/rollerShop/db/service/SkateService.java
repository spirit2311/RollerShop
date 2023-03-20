package com.example.rollerShop.db.service;

import com.example.rollerShop.db.dto.SkateDto;

import java.util.List;
import java.util.UUID;

public interface SkateService {
    List<SkateDto> getSkateByUuid(UUID uuid);

    List<SkateDto> getAllSkates(String brand, String discipline, Integer year, String sortYear, String sortDirection, Integer priceFrom, Integer priceTo);

    List<SkateDto> getRollerSkateModelAndBrand(String search);

    SkateDto saveSkate(SkateDto skateData);

    void updateSkate(UUID uuid, SkateDto newSkateData);

    void deleteSkate(UUID uuid);
}
