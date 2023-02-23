package com.example.rollerShop.db.service.impl;

import com.example.rollerShop.db.dto.SkateDto;
import com.example.rollerShop.db.mappers.SkateMapper;
import com.example.rollerShop.db.entity.Brand;
import com.example.rollerShop.db.entity.Discipline;
import com.example.rollerShop.db.entity.Skate;
import com.example.rollerShop.db.repository.BrandRepository;
import com.example.rollerShop.db.repository.DisciplineRepository;
import com.example.rollerShop.db.repository.SkateRepository;
import com.example.rollerShop.db.service.SkateService;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkateServiceImp implements SkateService {

    private final SkateRepository skateRepository;

    private final SkateMapper skateMapper;

    private final BrandRepository brandRepository;

    private final DisciplineRepository disciplineRepository;

    @Override
    public List<SkateDto> getSkateByUuid(UUID uuid) {
        return skateRepository.findByUuid(uuid)
                .stream()
                .map(skateMapper::toSkateDto)
                .collect(Collectors.toList());
//                .orElseThrow(() -> new SkateNotFoundException(id));
    }

    @Override
    public List<SkateDto> getAllSkates(String brand, String discipline, Integer year, String sortYear, String sortDirection, Integer priceFrom, Integer priceTo) {
        Specification<Skate> specification = (skateRoot, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(brand)){
                predicates.add(criteriaBuilder.like(
                        skateRoot.join("brand", JoinType.INNER)
                                .get("brand").as(String.class), "%" + brand + "%"));
            }

            if (StringUtils.hasText(discipline)) {
                predicates.add(criteriaBuilder.like(skateRoot.get("discipline"), "%" + discipline + "%"));
            }

//            if (StringUtils.hasText(String.valueOf(year))){
//                predicates.add(criteriaBuilder.like(skateRoot.get("year"), "%" + year + "%"));
//            }
//

            if (sortYear.equals("desc")) {
                query.orderBy(criteriaBuilder.desc(skateRoot.get("year")));
            }

            if (sortYear.equals("asc")) {
                query.orderBy(criteriaBuilder.asc(skateRoot.get("year")));
            }


            if (sortDirection.equals("desc")) {
                query.orderBy(criteriaBuilder.desc(skateRoot.get("price")));

            }
            if (sortDirection.equals("asc")) {
                query.orderBy(criteriaBuilder.asc(skateRoot.get("price")));
            }

            predicates.add(
                    criteriaBuilder.and(
                            criteriaBuilder.greaterThan(skateRoot.get("price"), priceFrom),
                            criteriaBuilder.lessThan(skateRoot.get("price"), priceTo))
            );

            return criteriaBuilder.and(
                    predicates.toArray(new Predicate[0])
            );
        };

        return skateRepository.findAll(specification)
                .stream()
                .map(skateMapper::toSkateDto)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<SkateDto> searchByBrandAndModel(String brand, String model) {
//
//        Specification<Skate> specification = (root, query, criteriaBuilder) -> {
//            List<Predicate> predicates = new ArrayList<>();
//
//            if (StringUtils.hasText(brand)){
//                predicates.add(criteriaBuilder.like(
//                        root.join("brand", JoinType.INNER)
//                                .get("brand").as(String.class), "%" + brand + "%"));
//            }
//            if (StringUtils.hasText(model)) {
//                predicates.add(criteriaBuilder.like(root.get("model"), "%" + model + "%"));
//            }
//            return criteriaBuilder.and(
//                    predicates.toArray(new Predicate[0])
//            );
//
//        };
//        return skateRepository.findAll(specification)
//                .stream()
//                .map(skateMapper::toSkateDto)
//                .collect(Collectors.toList());
//    }

    @Override
    public SkateDto saveSkate(SkateDto skateData) {
        Discipline discipline = disciplineRepository.findById(skateData.getDisciplineId())
                .orElseThrow(() -> new RuntimeException("discipline not found"));
        Brand brand = brandRepository.findById(skateData.getBrandId())
                .orElseThrow(() -> new RuntimeException("brand not found"));
        Skate skate = skateMapper.toSkate(skateData);
        skate.setDiscipline(discipline);
        skate.setBrand(brand);
        skateRepository.save(skate);
        return skateData;
    }

    @Transactional
    @Override
    public void updateSkate(UUID uuid, SkateDto updateSkateData) {
        Discipline discipline = disciplineRepository.findById(updateSkateData.getDisciplineId())
                .orElseThrow(() -> new RuntimeException("discipline not found"));
        Brand brand = brandRepository.findById(updateSkateData.getBrandId())
                .orElseThrow(() -> new RuntimeException("brand not found"));
        Skate skate = skateRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Skate with UUID %s no found", uuid)
                ));
        Skate newSkateData = skateMapper.toSkate(updateSkateData);
        skate.setBrand(brand);
        skate.setDiscipline(discipline);
        skate.setModel(newSkateData.getModel());
        skate.setYear(newSkateData.getYear());
        skate.setPrice(newSkateData.getPrice());
        skate.setDescription(newSkateData.getDescription());
//        skateRepository.save(newSkateData);
    }

    @Override
    @Transactional
    public void deleteSkate(UUID uuid) {
        skateRepository.deleteByUuid(uuid);
    }
}
