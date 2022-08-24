package com.example.fluxdemo.web;

import com.example.fluxdemo.domain.Customer;
import com.example.fluxdemo.domain.CustomerRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.awt.*;
import java.time.Duration;

@RestController
@Slf4j
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final Sinks.Many<Customer> sink;

    //A요청
    //B요청
    // 머지할수있는 스트림

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    @GetMapping("/flux")
    public Flux<Integer> fluxtest() {
        return Flux.just(1, 2, 3, 4, 5).delayElements(Duration.ofSeconds(1)).log();
    }

    @GetMapping(value = "/fluxStream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> fluxtestStream() {
        return Flux.just(1, 2, 3, 4, 5).delayElements(Duration.ofSeconds(1)).log();
    }

    @GetMapping(path = "/customer")
    public Flux<Customer> findAll() {
        return customerRepository.findAll().log();
    }

    @GetMapping("/customer/{id}")
    public Mono<Customer> findByid(@PathVariable Long id) {
        return customerRepository.findById(id).log();
    }

    //연결을 계속 유지시킴
    //find All sse
    @GetMapping(value = "/customer/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<Customer>> findAllsse() {
        return
                sink.asFlux().map(c -> ServerSentEvent.builder(c).build());
    }

    @GetMapping("/customer1")
    public Mono<Customer> sace() {
        return customerRepository.save(new Customer("gildong", "hong")).doOnNext(c ->
                {
                    sink.tryEmitNext(c);
                }
        );
    }

}
