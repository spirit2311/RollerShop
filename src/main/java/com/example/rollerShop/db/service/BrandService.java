package com.example.rollerShop.db.service;

import com.example.rollerShop.db.dtoEnity.BrandDto;
import com.example.rollerShop.db.dtoEnity.DisciplineDto;
import com.example.rollerShop.db.entity.Brand;

import java.util.List;
import java.util.UUID;

public interface BrandService {

    List<Brand> getBrandByUuid(UUID uuid);

    List<Brand> getAllBrands();


    Brand saveBrand(BrandDto brandData);

    Brand updateBrand(Brand newBrandData);

    void deleteBrand(UUID uuid);
}
