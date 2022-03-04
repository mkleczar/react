package com.example.react;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Flow.Subscriber;
import static java.util.concurrent.Flow.Subscription;

public class TemperatureSubscription implements Subscription {

    private static final ExecutorService service = Executors.newSingleThreadExecutor();

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
        service.submit(() -> {
            for (int i = 0; i < n; ++i) {
                try {
                    subscriber.onNext(temperatureHub.whatIsTemperatureIn(city));
                } catch (Exception e) {
                    subscriber.onError(e);
                    break;
                }
            }
        });
    }

    @Override
    public void cancel() {
        subscriber.onComplete();
    }
}
