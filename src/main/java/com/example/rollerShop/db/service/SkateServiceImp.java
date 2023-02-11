package com.example.rollerShop.db.service;

import com.example.rollerShop.db.dtoEnity.SkateDto;
import com.example.rollerShop.db.dtoEnity.SkateMapper;
import com.example.rollerShop.db.entity.Brand;
import com.example.rollerShop.db.entity.Discipline;
import com.example.rollerShop.db.entity.Skate;
import com.example.rollerShop.db.repository.BrandRepository;
import com.example.rollerShop.db.repository.DisciplineRepository;
import com.example.rollerShop.db.repository.SkateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
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
    public List<SkateDto> getAllSkates(String brand, String discipline, Integer year, String sortDirection, Integer priceFrom, Integer priceTo) {
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
        Skate skate = skateRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Skate with UUID %s no found", uuid)
                ));
        Skate newSkateData = skateMapper.toSkate(updateSkateData);
        skate.setBrand(newSkateData.getBrand());
        skate.setDiscipline(newSkateData.getDiscipline());
        skate.setModel(newSkateData.getModel());
        skate.setYear(newSkateData.getYear());
        skate.setPrice(newSkateData.getPrice());
        skate.setDescription(newSkateData.getDescription());
    }

    @Override
    public void deleteSkate(Integer id) {
        skateRepository.deleteById(id);
    }
}
