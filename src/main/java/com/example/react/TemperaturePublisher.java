package com.example.react;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Publisher;

public class TemperaturePublisher implements Publisher<TemperatureInfo> {

    @Override
    public void subscribe(Subscriber<? super TemperatureInfo> subscriber) {
    }
}
