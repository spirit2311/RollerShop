package com.example.rollerShop.db.service;

import com.example.rollerShop.db.dtoEnity.SkateDto;
import com.example.rollerShop.db.dtoEnity.SkateMapper;
import com.example.rollerShop.db.repository.SkateRepository;
import com.example.rollerShop.db.entity.Skate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkateServiceImp implements SkateService {

    private final SkateRepository skateRepository;

    private final SkateMapper skateMapper;

    @Override
    public List<SkateDto> getSkateById(Integer id) {
        return skateRepository.findById(id)
                .stream()
                .map(skateMapper::toSkateDto)
                .collect(Collectors.toList());
//                .orElseThrow(() -> new SkateNotFoundException(id));
    }

    @Override
    public List<SkateDto> getAllSkates(String brand, String discipline, String sortDirection, Integer priceFrom, Integer priceTo) {
        Specification<Skate> specification = (skateRoot, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(brand)) {
                predicates.add(criteriaBuilder.like(skateRoot.get("brand"), "%" + brand + "%"));
            }

            if (StringUtils.hasText(discipline)) {
                predicates.add(criteriaBuilder.like(skateRoot.get("discipline"), "%" + discipline + "%"));
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

    @Override
    public Skate saveSkate(Skate skateData) {
        return skateRepository.save(skateData);
    }

    @Override
    public Skate updateSkate(Skate newSkateData) {
        return skateRepository.save(newSkateData);
    }

    @Override
    public void deleteSkate(Integer id) {
        skateRepository.deleteById(id);
    }
}
