package com.example.rollerShop.db.repository;

import com.example.rollerShop.db.entity.Skate;
import lombok.NonNull;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SkateRepository extends JpaRepository<Skate, Integer>, JpaSpecificationExecutor<Skate> {
    @EntityGraph()
    @NonNull
    Optional<Skate> findById(Integer id);

    Optional<Skate> findByUuid(UUID uuid);


    @Modifying
    void deleteByUuid(UUID uuid);

}
