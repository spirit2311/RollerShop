package com.example.rollerShop.controller;

import com.example.rollerShop.db.controller.SkateController;
import com.example.rollerShop.db.repository.SkateRepository;
import com.example.rollerShop.db.service.SkateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
//@ActiveProfiles(profiles = "test")
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(initializers = SkateControllerTests.Initializer.class)
@Slf4j
public class SkateControllerTests {

    //    @Autowired
//    private MockMvc mockMvc;
    @Autowired
    public SkateController controller;
    @Autowired
    public SkateService skateService;
    @Autowired
    private SkateRepository skateRepository;
    @ClassRule
    public static final MySQLContainer<?> mysql = new MySQLContainer("mysql:latest")
            .withDatabaseName("test");

    private ObjectMapper objectMapper = new ObjectMapper();

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(@NotNull ConfigurableApplicationContext configurableApplicationContext) {
            mysql.start();
            configurableApplicationContext.getEnvironment().getSystemProperties().put("spring.datasource.url", mysql.getJdbcUrl() + "?allowPublicKeyRetrieval=true&createDatabaseIfNotExist=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8");
            configurableApplicationContext.getEnvironment().getSystemProperties().put("spring.datasource.username", mysql.getUsername());
            configurableApplicationContext.getEnvironment().getSystemProperties().put("spring.datasource.password", mysql.getPassword());

        }
    }

    @Test
    public void addSkatesFromDb() {
//        skateRepository.save(new Skate(999, "TEST", "MODEL", "SLALOM", 999, "DESCRIPTION"));
        log.info("{}", skateRepository.findAll());
        log.info("{}", skateRepository.findAll().size());
        //given
//        Skate skate1 = Skate.builder()
//                .id(1)
//                .brand("Seba")
//                .model("FrJun")
//                .discipline("kids")
//                .price(100)
//                .description("kids skate")
//                .build();
//
//        Skate skate2 = Skate.builder()
//                .id(1)
//                .brand("Powerslide")
//                .model("Jun")
//                .discipline("kids")
//                .price(210)
//                .description("kids skate")
//                .build();
//
//        skateRepository.save(skate1);
//        skateRepository.save(skate2);
//
//        //when
//        List<Skate> skates = skateRepository.findAll();
//
//        //then
//        assertAll(
//                () -> assertEquals("Seba", skates.get(1).getBrand())
//        );
    }

//    @Test
//    public void givenId_whenIdMatchIgnoringCase_thenSkateShouldBeFound() throws Exception {
//        this.mockMvc.perform(get("/all/brand"))
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) jsonPath("$.brand").value(""));
//    }

//    @Test
//    @DisplayName("THIS IS MY TEST WITH SPECIFIC CASE")
//    public void givenFindAllApiUrl_whenReturnList_thenListSizeShouldMatch() throws Exception {
//        this.mockMvc.perform(get("/skates/all")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.size").value(this.skateRepository.findAll().size()));
//    }
}
