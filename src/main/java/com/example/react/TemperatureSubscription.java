package com.example.react;

import java.util.stream.IntStream;

import static java.util.concurrent.Flow.Subscriber;
import static java.util.concurrent.Flow.Subscription;

public class TemperatureSubscription implements Subscription {

    private final TemperatureHub temperatureHub;
    private final Subscriber<? super TemperatureInfo>  subscriber;
    private final String city;

    public TemperatureSubscription(TemperatureHub temperatureHub, Subscriber<? super TemperatureInfo> subscriber, String city) {
        this.temperatureHub = temperatureHub;
        this.subscriber = subscriber;
        this.city = city;
    }

    @Override
    public void request(long n) {
    }

    @Override
    public void cancel() {
        subscriber.onComplete();
    }
}
