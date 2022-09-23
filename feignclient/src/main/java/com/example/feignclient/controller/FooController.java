package com.example.feignclient.controller;

import com.example.feignclient.feign.FooClient;
import feign.Capability;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.clientconfig.FeignClientConfigurer;
import org.springframework.context.annotation.Import;

@Import(FeignClientConfigurer.class)
public class FooController {

    private FooClient fooClient;
    private FooClient adminClient;

    @Autowired
    public FooController (Client client, Encoder encoder, Decoder decoder, Contract contract, Capability capability){
        this.fooClient = Feign.builder().client(client)
                .encoder(encoder)
                .decoder(decoder)
                .contract(contract)
                .addCapability(capability)
                .requestInterceptor(new BasicAuthRequestInterceptor("user","user"))
                .target(FooClient.class, "url");

        this.adminClient = Feign.builder().client(client)
                .encoder(encoder)
                .decoder(decoder)
                .contract(contract)
                .addCapability(capability)
                .requestInterceptor(new BasicAuthRequestInterceptor("admin","admin"))
                .target(FooClient.class, "url");


    }

}
