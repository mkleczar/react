package com.example.react;

import java.util.Random;

public class TemperatureHub {
    private static final Random random = new Random();

    public TemperatureInfo whatIsTemperatureIn(String city) {
        if (random.nextInt(10) == 0) {
            throw new RuntimeException("Temperature sensor error");
        }
        return new TemperatureInfo(city, random.nextInt(35));
    }
}
