package com.velb.fibonacciadder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FibonacciAdderService {


    private final RSocketRequester rSocketRequester;

    @Caching(
            cacheable = {
                    @Cacheable(value = "cache", key = "#head"),
                    @Cacheable(value = "cache", key = "#tail")
            }
    )
    public Mono<Long> callFebMicroservice(Long head, Long tail) {
        return rSocketRequester
                .route("fibonacciSequence")
                .retrieveFlux(String.class)
                .map(Long::parseLong)
                .filter(num -> num >= head && num <= tail)
                .reduce(Long::sum);
    }

}
