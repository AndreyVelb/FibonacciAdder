package com.velb.fibonaccigenerator.service;

import com.velb.fibonaccigenerator.FebbonachiNumbersStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FibonacciGeneratorService {


    private final FebbonachiNumbersStorage febbonachiNumbersStorage;


    public Flux<Long> generateSequence() {

        return Flux.fromIterable(febbonachiNumbersStorage.getStorage());

    }

}
