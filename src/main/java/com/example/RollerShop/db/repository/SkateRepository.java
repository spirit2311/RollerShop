package com.example.RollerShop.db.repository;

import com.example.RollerShop.db.entity.Skate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkateRepository extends JpaRepository<Skate,Integer> {
    //TODO spring query methods
    Optional<Skate> findById(Integer id);

}
