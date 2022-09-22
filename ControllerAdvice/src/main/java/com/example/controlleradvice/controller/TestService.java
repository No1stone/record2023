package com.example.controlleradvice.controller;

import com.example.controlleradvice.controller.cus.cus1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {

    public void test1Service(){

        Optional<String> bb = Optional.of("aa");

        bb.orElseThrow(() -> new cus1());

    }


}
