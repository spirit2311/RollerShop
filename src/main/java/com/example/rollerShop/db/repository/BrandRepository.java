package com.example.rollerShop.db.repository;

import com.example.rollerShop.db.entity.Brand;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;
import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    @NonNull
    Optional<Brand> findById(Integer id);

    @Modifying
    void deleteByUuid(UUID uuid);

    Optional<Brand> findByUuid(UUID uuid);

}
