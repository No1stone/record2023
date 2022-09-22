package com.example.redisinittest.biz;

import com.example.redisinittest.db.redis.entity.Person;
import com.example.redisinittest.db.redis.repo.RedPersonRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {


    private final RedPersonRepository redPersonRepository;

    public void saveTest() {

        List<Person> lp = Arrays.asList(
                new Person("token1", "test1", 21, LocalDateTime.now()),
                new Person("token2", "test2", 22, LocalDateTime.now()),
                new Person("token3", "test3", 23, LocalDateTime.now()),
                new Person("token4", "test4", 24, LocalDateTime.now()),
                new Person("token5", "test5", 25, LocalDateTime.now())
        );
        redPersonRepository.saveAll(lp);



    }

    public Person getId(String id) {

        Person result = redPersonRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());

        log.info("get - {}", new Gson().toJson(result));

        return result;
    }

    public void test3(){
        String sn = null;
        log.info("init");
        AssertService.builder().notnull("s").stringCheck("s");
        log.info("init1");
//        AssertService.builder().notnull(sn).stringCheck("s");
        log.info("init2");
        AssertService.builder().notnull("s").stringCheck("123");
        log.info("init3");
    }

}
