package com.example.singlequeue.config;

import com.example.singlequeue.controller.vo.AcsVo;
import com.example.singlequeue.vo.AcsQueue;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
@Slf4j
public class ConfigAcsSystem {

    private Map<String, String> item;
    private Map<String, AcsVo> startOder;

    @PostConstruct
    public void init() {
        this.item = new HashMap<>();
        this.startOder = new HashMap<>();
        log.info("items - {} {}", new Gson().toJson(item), new Gson().toJson(startOder));
    }


    public Map<String, AcsVo> getStartOder(){
//        log.info(" startoder All - {} ", new Gson().toJson(startOder));
        return startOder;
    }

    public void addStartOder(String key, AcsVo val){
        startOder.put(key, val);
    }

    public void removeStartOder(String key, String val){
        startOder.remove(key, val);
    }

    public void removeStartOder(String key){
        startOder.remove(key);
    }





    public Map<String, String> getItems() {
        return item;
    }
    public void setItems(String serviceGroup, String campaign){
        this.item.put(serviceGroup,campaign);
    }

}
