package com.example.rollerShop.db.repository;

import com.example.rollerShop.db.entity.Discipline;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;
import java.util.UUID;

public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {

    @NonNull
    Optional<Discipline> findById(Integer id);

    @Modifying
    void deleteByUuid(UUID uuid);

    Optional<Discipline> findByUuid(UUID uuid);

}
