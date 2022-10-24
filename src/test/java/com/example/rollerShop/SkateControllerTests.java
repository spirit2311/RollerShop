package com.example.rollerShop;

import com.example.rollerShop.db.controller.SkateController;
import com.example.rollerShop.db.entity.Skate;
import com.example.rollerShop.db.repository.SkateRepository;
import com.example.rollerShop.db.service.SkateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.nio.cs.Surrogate.is;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SkateControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    public SkateController controller;
    @Autowired
    public SkateService skateService;
    @Autowired
    private SkateRepository skateRepository;


    private ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    void setup() {
        skateRepository.findAll();
    }

    @Test
    public void givenSkateObject_whenCreateSkate_thenReturnSavedSkate() throws Exception {

        // given - precondition or setup
        Skate skate = Skate.builder()
                .id(1)
                .brand("Seba")
                .model("FrJun")
                .discipline("kids")
                .price(100)
                .description("kids skate")
                .build();

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/skates")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(skate)));

        // then - verify the result or output using assert statements
        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$.id",
                        is(skate.getId())))
                .andExpect((ResultMatcher) jsonPath("$.brand",
                        is(Integer.parseInt(skate.getBrand()))))
                .andExpect((ResultMatcher) jsonPath("$.model",
                        is(Integer.parseInt(skate.getModel()))))
                .andExpect((ResultMatcher) jsonPath("$.discipline",
                        is(Integer.parseInt(skate.getDiscipline()))))
                .andExpect((ResultMatcher) jsonPath("$.price",
                        is(skate.getPrice())))
                .andExpect((ResultMatcher) jsonPath("$.description",
                        is(Integer.parseInt(skate.getDescription()))));

    }
//
//    @Test
//    public void givenListOfSkates_whenGetAllSkates_thenReturnSkatesList() throws Exception{
//        // given - precondition or setup
//        List<Skate> listOfSkates = new ArrayList<>();
//        listOfSkates.add(Skate.builder()
//                .id(1)
//                .brand("Seba")
//                .model("FrJun")
//                .discipline("kids")
//                .price(100)
//                .description("kids skate")
//                .build());
//        listOfSkates.add(Skate.builder()
//                .id(1)
//                .brand("Powerslide")
//                .model("Jun")
//                .discipline("kids")
//                .price(210)
//                .description("kids skate")
//                .build());
//        skateRepository.saveAll(listOfSkates);
//        // when -  action or the behaviour that we are going test
//        ResultActions response = mockMvc.perform(get("/rollerskate"));
//
//        // then - verify the output
//        response.andExpect(status().isOk())
//                .andDo(print())
//                .andExpect((ResultMatcher) jsonPath("$.size()",
//                        is(listOfSkates.size())));
//
//    }


}
