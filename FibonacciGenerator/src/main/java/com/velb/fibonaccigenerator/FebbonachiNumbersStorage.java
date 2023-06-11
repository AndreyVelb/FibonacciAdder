package com.velb.fibonaccigenerator;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FebbonachiNumbersStorage {

    @Getter
    private ArrayList<Long> storage;

    @PostConstruct
    private void createStorage() {
        storage = new ArrayList<>();

        for (int i = 0; i <= 50; i++) {
            long febbonachiNumber = (long) ((Math.pow((1 + Math.sqrt(5)) / 2, i) - Math.pow((1 - Math.sqrt(5)) / 2, i)) / Math.sqrt(5));

            storage.add(febbonachiNumber);
        }
    }

}
