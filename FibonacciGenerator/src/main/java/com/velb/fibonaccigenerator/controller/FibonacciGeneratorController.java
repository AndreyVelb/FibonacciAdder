package com.velb.fibonaccigenerator.controller;

import com.velb.fibonaccigenerator.service.FibonacciGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Controller
@RequiredArgsConstructor
public class FibonacciGeneratorController {


    private final FibonacciGeneratorService fibonacciGeneratorService;


    @MessageMapping("fibonacciSequence")
    public Flux<String> getFibonacciSequence() {

        return fibonacciGeneratorService.generateSequence()
                .map(String::valueOf)
                .delayElements(Duration.ofMillis(1));

    }

}
