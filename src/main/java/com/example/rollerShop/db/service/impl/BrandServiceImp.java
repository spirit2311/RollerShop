package com.example.rollerShop.db.service.impl;

import com.example.rollerShop.db.dtoEnity.BrandDto;
import com.example.rollerShop.db.entity.Brand;
import com.example.rollerShop.db.repository.BrandRepository;
import com.example.rollerShop.db.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandServiceImp implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<Brand> getBrandByUuid(UUID uuid) {
        return brandRepository.findByUuid(uuid)
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public List<Brand> getAllBrands() {

        return brandRepository.findAll();
    }

    @Override
    public Brand saveBrand(BrandDto brandData) {
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandData, brand);
        return brandRepository.save(brand);
    }

    @Override
    public Brand updateBrand(Brand newBrandData) {
        return brandRepository.save(newBrandData);
    }

    @Override
    @Transactional
    public void deleteBrand(UUID uuid) {
        brandRepository.deleteByUuid(uuid);
    }
}
