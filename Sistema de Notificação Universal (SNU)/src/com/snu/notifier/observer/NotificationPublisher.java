package com.snu.notifier.observer;

import java.util.ArrayList;
import java.util.List;

import com.snu.notifier.observer.NotificationSubscriber;

public class NotificationPublisher {
    private List<NotificationSubscriber> subscribers = new ArrayList<>();

    public void addSubscriber(NotificationSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(NotificationSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(NotificationEvent event) {
        for (NotificationSubscriber subscriber : subscribers) {
            subscriber.update(event);
        }
    }
}