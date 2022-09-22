package com.example.fluxdemo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
public class Customer {
    @Id
    private Long id;

    private final String firstName;

    private final String lastName;

}
