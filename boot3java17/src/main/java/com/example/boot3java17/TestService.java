package com.example.boot3java17;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {

    public String test2() {
        List<String> lis = List.of("a1", "a2", "a3", "a4");
        return lis.stream().collect(Collectors.joining());
    }

    public Map test3() {
        Map<String, String> maps = Map.of(
                "a1", "a1",
                "a2", "a2",
                "a3", "a3"
        );
        //maps.put("a4", "a4"); //동작안함 불변속성이라고함
        Map<String, String> maps1 = new HashMap<>(maps);
        maps1.put("a4", "a4");
        log.info("maps - {}", new Gson().toJson(maps1));
        return maps1;
    }

    public String test4() {

        if ("".isBlank()) {
            log.info("true");
        } else {
            log.info("false");
        }
        log.info("lines - {}", new Gson().toJson("asd\nqwe\nzxc\nasd\nqwe\nzxc\n".lines().collect(Collectors.joining(","))));

        log.info("Test Text1 - {}", new Gson().toJson(" Test Text ".strip()));
        log.info("Test Text2 - {}", new Gson().toJson(" Test Text ".stripLeading()));
        log.info("Test Text3 - {}", new Gson().toJson(" Test Text ".stripTrailing()));
        log.info("Test Text4 - {}", new Gson().toJson(" Test Text ".trim()));
        log.info("Test Text5 - {}", new Gson().toJson(" 반복 ".repeat(10)));
        log.info("Test Text6 - {}", new Gson().toJson("""
                "test1":5
                "test2":"test2"
                "test3":true
                  """));
        return "check";
    }

    public String test5() {

        List<String> a = List.of("A", "B", "C", "D", "E", "F", "G", "H");
        for (String e : a) {
            switch (e) {
                case "A", "B" -> log.info("a,b");
                case "C", "D" -> log.info("c,d");
                case "E", "F" -> log.info("e,f");
                case "G", "H" -> log.info("g,h");
            }
        }
        return a.stream().collect(Collectors.joining());
    }



}
