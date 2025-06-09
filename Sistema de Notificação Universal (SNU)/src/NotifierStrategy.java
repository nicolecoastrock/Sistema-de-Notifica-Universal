package com.snu.notifier.strategy;

import com.snu.notifier.model.User;

public interface NotifierStrategy {
    void sendNotification(User user, String message);
}