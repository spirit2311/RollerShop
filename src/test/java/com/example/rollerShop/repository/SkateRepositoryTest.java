//package com.example.rollerShop.repository;
//
//import com.example.rollerShop.db.entity.Skate;
//import com.example.rollerShop.db.repository.SkateRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//
//@DataJpaTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class SkateRepositoryTest {
//
//    @Autowired
//    private SkateRepository skateRepository;
//
//    @Test
//    @Order(1)
//    @Rollback(value = false)
//    public void saveSkateTest() {
//
//        Skate skate = Skate.builder()
//                .brand("Powerslide")
//                .model("Jun")
//                .discipline("kids")
//                .price(210)
//                .description("kids skate")
//                .build();
//
//        skateRepository.save(skate);
//
//        Assertions.assertThat(skate.getId()).isGreaterThan(0);
//    }
//}
