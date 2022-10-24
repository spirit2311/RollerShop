package com.example.RollerShop.db.service;

import com.example.RollerShop.db.repository.SkateRepository;
import com.example.RollerShop.db.entity.Skate;
import com.example.RollerShop.db.exception.SkateNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkateServiceImp implements SkateService {

    private SkateRepository skateRepository;

    @Autowired
    public SkateServiceImp(SkateRepository skateDao) {
        this.skateRepository = skateDao;
    }

    @Override
    public Skate getSkateById(Integer id) {
        return skateRepository.findById(id).orElseThrow(() -> new SkateNotFoundException(id));
    }

//    @Override
//    public List<Skate> getSkateByBrand(String brand) {
//        return skateRepository.findByBrand(brand);
//    }
//
//    @Override
//    public List<Skate> getSkateByDiscipline(String discipline) {
//        return skateRepository.findByDiscipline(discipline);
//    }
//
//    @Override
//    public List<SkateDto> getSortSkateAsc() {
//        return skateRepository.sortByPriceAsc()
//                .stream()
//                .map(skateMapper::toSkateDto)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Skate> getSortSkateDesc() {
//        return skateRepository.sortByPriceDesc()
//                .stream()
//                .map(skateMapper::toSkateDto)
//                .collect(Collectors.toList())
//        ;
//    }
//
//    @Override
//    public List<Skate> getSortRangePrice(Integer startPrice, Integer finishPrice) {
//        return skateRepository.sortByRangePrice(startPrice, finishPrice);
//    }
//    @Override
//    public List<Skate> getAllSkates(){
//        return skateRepository.findAll();
//    }

    @Override
    public List<Skate> getAllSkates(String brand, String discipline, Optional<String> sortDirection, Integer priceFrom, Integer priceTo){
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

        return skateRepository.findAll(specification);
    }

    @Override
    public Skate saveSkate(Skate skateData) {
        return  skateRepository.save(skateData);
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
