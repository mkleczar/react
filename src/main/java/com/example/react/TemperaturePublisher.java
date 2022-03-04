package com.example.react;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Publisher;

public class TemperaturePublisher implements Publisher<TemperatureInfo> {

    private final TemperatureHub temperatureHub;
    private final String city;

    public TemperaturePublisher(TemperatureHub temperatureHub, String city) {
        this.temperatureHub = temperatureHub;
        this.city = city;
    }

    @Override
    public void subscribe(Subscriber<? super TemperatureInfo> subscriber) {
        subscriber.onSubscribe(new TemperatureSubscription(temperatureHub, subscriber, city));
    }
}
