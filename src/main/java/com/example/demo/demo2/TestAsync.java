package com.example.demo.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.time.Duration;
import java.util.List;

@Component
public class TestAsync {

    private WebClient webClient;

    public TestAsync() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

    public Mono<String> processMessage() {
        System.out.println("PROCESS MESSAGE " + Thread.currentThread().getName());
        return Mono.just("AAA")
                .doOnNext(s -> System.out.println("EMIT NEXT " + s + Thread.currentThread()));
//        return webClient.get()
//                .uri("/test")
//                .retrieve()
//                .bodyToMono(String[].class)
//                .log("API CALL");
    }

    public Mono<String> simulateEmitData() {
        return Mono.just("DATA");
    }
}
