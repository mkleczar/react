package com.example.react;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

@Slf4j
public class TemperatureSubscriber implements Subscriber<TemperatureInfo> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(TemperatureInfo item) {
        log.info("Event: {}", item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("Error", throwable);
    }

    @Override
    public void onComplete() {
        log.info("Data transmission completed");
    }
}
