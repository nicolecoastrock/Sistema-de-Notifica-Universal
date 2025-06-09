package com.snu.notifier.observer;

import com.snu.notifier.model.User;

public class NotificationEvent {
    private String message;
    private User user;
    private String eventType; // Ex: "PROMOTION", "ACCOUNT_UPDATE", "SYSTEM_ALERT"

    public NotificationEvent(String message, User user, String eventType) {
        this.message = message;
        this.user = user;
        this.eventType = eventType;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public String getEventType() {
        return eventType;
    }
}