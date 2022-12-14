package com.example.rollerShop.service;

import com.example.rollerShop.db.dtoEnity.SkateDto;
import com.example.rollerShop.db.dtoEnity.SkateMapper;
import com.example.rollerShop.db.entity.Skate;
import com.example.rollerShop.db.repository.SkateRepository;
import com.example.rollerShop.db.service.SkateServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@TestInstance(PER_CLASS)
public class SkateServiceTests {

    @Mock
    private SkateRepository skateRepository;

    @InjectMocks
    private SkateServiceImp skateService;


    private Skate skate;

    @Mock
    private SkateMapper skateMapper;


    @BeforeEach
    void setUp() {
        skate = Skate.builder()
                .id(1)
                .brand("Powerslide")
                .model("Jun")
                .discipline("kids")
                .price(210)
                .description("kids skate")
                .build();
    }

    @DisplayName("Save Skate")
    @Test
    void givenSkateObject_whenSaveSkate_thenReturnSkateObject() {
        given(skateRepository.save(skate)).willReturn(skate);

        System.out.println(skateRepository);
        System.out.println(skateService);

        Skate savedSkate = skateService.saveSkate(skate);

        System.out.println(savedSkate);

        Assertions.assertThat(savedSkate).isNotNull();
    }

    //TODO 102 line getAllSkates use findAll(specification) but 99 line use findAll() in JpaRepository
    @DisplayName("Test for getAllSkates")
    @Test
    public void givenSkatesList_whenGetAllSkates_thenReturnSkatesList() {
        // given - ?????????????????????????????? ?????????????? ?????? ??????????????????

        Skate skate1 = Skate.builder()
                .id(2)
                .brand("Seba")
                .model("Juni")
                .discipline("kids")
                .price(240)
                .description("kids skate")
                .build();

        Skate skate2 = Skate.builder()
                .id(3)
                .brand("Powerslide")
                .model("Juni")
                .discipline("slalom")
                .price(340)
                .description("kids skate")
                .build();

//        given(skateRepository.findAll()).willReturn(List.of(skate, skate1));

            given(skateRepository.findAll()).willReturn(List.of(skate1, skate2));

        // when -  ???????????????? ?????? ??????????????????, ?????????????? ???? ???????????????????? ????????????????????????????
        List<SkateDto> skateList = skateService.getAllSkates("Powerslide", "slalom", "acs", 200, 350);

        // then - ???????????????? ????????????
//        Assertions.assertThat(skateList).isEqualTo(skateMapper.toSkateDtos((List<Skate>) skate));
        Assertions.assertThat(skateList.size()).isEqualTo(1);
    }


    @DisplayName("Test for getSkateById")
    @Test
    public void givenSkateId_whenGetSkateById_thenReturnSkateObject() {
        given(skateRepository.findById(1)).willReturn(Optional.of(skate));

        List<SkateDto> savedSkates = skateService.getSkateById(1);


        Assertions.assertThat(savedSkates.size()).isEqualTo(1);
        Assertions.assertThat(savedSkates.get(0)).isEqualTo(skateMapper.toSkateDto(skate));
    }

    @DisplayName("Test for updateSkate")
    @Test
    public void givenSkateObject_whenUpdateSkate_thenReturnUpdatedSkate() {
        given(skateRepository.save(skate)).willReturn(skate);

        skate.setPrice(450);
        skate.setBrand("Seba");

        Skate updatedSkate = skateService.updateSkate(skate);

        Assertions.assertThat(updatedSkate.getPrice()).isEqualTo(450);
        Assertions.assertThat(updatedSkate.getBrand()).isEqualTo("Seba");
    }

    @DisplayName("Test for deleteSkate")
    @Test
    public void givenSkateId_whenDeleteSkate_thenNothing() {
        int skateId = 1;

        willDoNothing().given(skateRepository).deleteById(skateId);

        skateService.deleteSkate(skateId);

        verify(skateRepository, times(1)).deleteById(skateId);
    }
}
