package com.example.react;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TemperatureInfo {
    private final String city;
    private final Integer temperature;

    public TemperatureInfo(String city, Integer temperature) {
        this.city = city;
        this.temperature = temperature;
    }
}
