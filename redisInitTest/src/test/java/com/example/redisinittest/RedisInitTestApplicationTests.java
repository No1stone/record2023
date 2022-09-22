package com.example.redisinittest;

import com.example.redisinittest.biz.TestService;
import com.example.redisinittest.biz.Testcont;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@SpringBootTest(    properties = {
        "spring.config.location=classpath:application.yml"})
@RunWith(SpringRunner.class)
class RedisInitTestApplicationTests {

    @Autowired
    private Testcont testcont;

    @Test
    void contextLoads() {

    }

}
