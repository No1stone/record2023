package com.example.flyway2;

import com.example.flyway2.db.entity.TbBotUser;
import com.example.flyway2.db.repo.TbBotUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final TbBotUserRepo tbBotUserRepo;

    @GetMapping("test1")
    public List<TbBotUser> test1(){
        return tbBotUserRepo.findAll();
    }

}
