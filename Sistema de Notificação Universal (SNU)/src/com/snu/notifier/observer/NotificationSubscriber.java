package com.snu.notifier.observer;

public interface NotificationSubscriber {
    void update(NotificationEvent event);
}