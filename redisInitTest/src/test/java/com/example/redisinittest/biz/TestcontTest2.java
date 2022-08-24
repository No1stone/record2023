package com.example.redisinittest.biz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.StandardCharsets;


@SpringBootTest(    properties = {
        "spring.config.location=classpath:application.yml"})
class TestcontTest2 {

    private MockMvc mockMvc;
//    @MockBean
    private TestService testService;
    @Autowired
    private Testcont testcont;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(testcont)
                .addFilter(new CharacterEncodingFilter(StandardCharsets.UTF_8.name(), true))
//                .alwaysExpect(MockMvcResultMatchers.status().isOk())
                .build();
    }

    @Test
    @DisplayName("ControllerTest1-1")
    void test1test() throws Exception {
        ResultActions resultActions = this.mockMvc
                .perform( MockMvcRequestBuilders
                        .get("/test1-1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print())
                ;

        Thread.sleep(5000);
    }

}