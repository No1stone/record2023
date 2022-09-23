package com.example.feignclient.feign;

import com.example.feignclient.config.FooConfigration;
import org.springframework.cloud.openfeign.FeignClient;

import javax.naming.Context;

@FeignClient(contextId = "fooClient", name = "stores", configuration = FooConfigration.class)
public interface FooClient {
}
