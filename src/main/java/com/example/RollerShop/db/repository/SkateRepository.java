package com.example.RollerShop.db.repository;

import com.example.RollerShop.db.entity.Skate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkateRepository extends JpaRepository<Skate,Integer> {
    Optional<Skate> findById(Integer id);

    @Query(value = "SELECT * FROM `rollerskate` WHERE brand = ?1", nativeQuery = true)
    List<Skate> findByBrand(String brand);

    @Query(value = "SELECT * FROM `rollerskate` WHERE discipline = ?1", nativeQuery = true)
    List<Skate> findByDiscipline(String discipline);

    @Query(value = "SELECT * FROM `rollerskate` ORDER BY price ASC", nativeQuery = true)
    List<Skate> sortByPriceAsc();

    @Query(value = "SELECT * FROM `rollerskate` ORDER BY price DESC", nativeQuery = true)
    List<Skate> sortByPriceDesc();

    @Query(value = "SELECT * FROM `rollerskate` WHERE price BETWEEN ?1 AND ?1", nativeQuery = true)
    List<Skate> sortByRangePrice(Integer startPrice, Integer finishPrice);

}
