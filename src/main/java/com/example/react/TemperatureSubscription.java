package com.example.react;

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
        for (int i = 0; i < n; ++i) {
            try {
                subscriber.onNext(temperatureHub.whatIsTemperatureIn(city));
            } catch (Exception e) {
                subscriber.onError(e);
                break;
            }
        }

    }

    @Override
    public void cancel() {
        subscriber.onComplete();
    }
}
