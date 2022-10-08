package com.example.RollerShop.db.dao;

import com.example.RollerShop.db.entity.Skate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

public interface SkateDao extends JpaRepository<Skate,Integer> {
    //TODO spring query methods

    Optional<Skate> findById(Integer id);

    List<Skate> findAllByType(String type);
//    Skate getSkateById(int id);
//
//    List<Skate> listSkates();
}
