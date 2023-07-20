package com.example.singlequeue;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SinglequeueApplication
//        implements ExitCodeGenerator
{

    public static void main(String[] args) {

        SpringApplication.run(SinglequeueApplication.class, args)
        ;
    }
//    @Override
//    public int getExitCode() {
//        return 130;
//    }
}
