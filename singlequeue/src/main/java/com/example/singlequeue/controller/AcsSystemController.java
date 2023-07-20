package com.example.singlequeue.controller;

import com.example.singlequeue.config.ConfigAcsSystem;
import com.example.singlequeue.controller.vo.AcsVo;
import com.example.singlequeue.controller.vo.StartVo;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/system")
@CrossOrigin("*")
public class AcsSystemController {

    private final ConfigAcsSystem configAcsSystem;

    @GetMapping("/test1")
    public void test1(@RequestParam(name = "key", required = true) String key
            , @RequestParam(name = "val", required = false) String val) {
       AcsVo sv =  configAcsSystem.getStartOder().get(key);
       sv.setLicenseCount(2);
    }

    @GetMapping("/campaign")
    public boolean check(@RequestParam(name = "key", required = true) String key) {
        log.info("key - {} {}", key, new Gson().toJson(configAcsSystem.getStartOder().get(key)));
        return configAcsSystem.getStartOder().keySet().contains(key);
    }

    @PostMapping("/campaign")
    public String start(@RequestBody StartVo sv) {
        log.info("campaign start -{}", new Gson().toJson(sv));
        configAcsSystem.addStartOder(sv.getKey(), sv.getVal());
        return "200";
    }

    @DeleteMapping("/campaign")
    public boolean delete(@RequestParam(name = "key", required = true) String key
    , @RequestParam(name = "val", required = false) String val
    ) {
        log.info("getId - {}", key);
        configAcsSystem.removeStartOder(key,val);
        return !configAcsSystem.getStartOder().containsKey(key);
    }


}
