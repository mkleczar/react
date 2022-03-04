package com.example.react;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Publisher;

public class TemperaturePublisher implements Publisher<TemperatureInfo> {

    private final TemperatureHub temperatureHub = new TemperatureHub();
    private final String city;

    public TemperaturePublisher(String city) {
        this.city = city;
    }

    @Override
    public void subscribe(Subscriber<? super TemperatureInfo> subscriber) {
        subscriber.onSubscribe(new TemperatureSubscription(temperatureHub, subscriber, city));
    }
}
