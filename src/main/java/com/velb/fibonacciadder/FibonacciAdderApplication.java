package com.velb.fibonacciadder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FibonacciAdderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FibonacciAdderApplication.class, args);
    }

}
