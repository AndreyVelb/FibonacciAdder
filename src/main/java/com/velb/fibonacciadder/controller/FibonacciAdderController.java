package com.velb.fibonacciadder.controller;

import com.velb.fibonacciadder.service.FibonacciAdderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class FibonacciAdderController {


    private final FibonacciAdderService fibonacciAdderService;


    @GetMapping(value = "/getSum", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Long> getSumOfFibonacciSeq(@RequestParam Long head, @RequestParam Long tail) {
        return fibonacciAdderService.callFebMicroservice(head, tail);
    }

}
