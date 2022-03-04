package com.example.react;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Publisher;

public class TemperatureReactTest {

    @Test
    public void reactTest() {
        Publisher<TemperatureInfo> publisher = new TemperaturePublisher("London");

        Subscriber<TemperatureInfo> subscriber = new TemperatureSubscriber();

        publisher.subscribe(subscriber);
    }
}
