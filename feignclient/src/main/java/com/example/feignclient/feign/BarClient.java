package com.example.feignclient.feign;


import com.example.feignclient.config.BarConfigration;
import org.springframework.cloud.openfeign.FeignClient;

//@FeignClient(contextId = "barClient", name = "stores", configuration = BarConfigration.class)
interface interface BarClient {
}
