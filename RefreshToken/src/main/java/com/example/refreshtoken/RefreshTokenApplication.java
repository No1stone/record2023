package com.example.refreshtoken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class RefreshTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(RefreshTokenApplication.class, args);
    }

}
