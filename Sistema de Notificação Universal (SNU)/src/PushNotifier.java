package com.snu.notifier.strategy;

import com.snu.notifier.model.User;

public class PushNotifier implements NotifierStrategy {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Enviando Push Notification para " + user.getUsername() + ": " + message);
        // Lógica real de envio de push notification aqui
    }
}