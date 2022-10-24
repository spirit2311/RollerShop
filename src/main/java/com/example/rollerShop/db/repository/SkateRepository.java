package com.example.rollerShop.db.repository;

import com.example.rollerShop.db.entity.Skate;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface SkateRepository extends JpaRepository<Skate,Integer> {
    Optional<Skate> findById(Integer id);

}
