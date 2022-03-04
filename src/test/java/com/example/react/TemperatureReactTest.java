package com.example.react;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Publisher;

public class TemperatureReactTest {

    @Test
    public void reactTest() {
        TemperatureHub temperatureHub = new TemperatureHub();

        Publisher<TemperatureInfo> publisher = new TemperaturePublisher(temperatureHub, "London");

        Subscriber<TemperatureInfo> subscriber = new TemperatureSubscriber();

        publisher.subscribe(subscriber);
    }

    @Test
    public void reactTwoSubscribersTest() {
        TemperatureHub temperatureHub = new TemperatureHub();

        Publisher<TemperatureInfo> publisher = new TemperaturePublisher(temperatureHub, "New York");

        Subscriber<TemperatureInfo> subscriber1 = new TemperatureSubscriber();
        Subscriber<TemperatureInfo> subscriber2 = new TemperatureSubscriber();

        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);
    }
}
