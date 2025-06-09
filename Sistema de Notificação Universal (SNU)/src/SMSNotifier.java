package com.snu.notifier.strategy;

import com.snu.notifier.model.User;

public class SMSNotifier implements NotifierStrategy {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Enviando SMS para " + user.getPhoneNumber() + ": " + message);
        // Lógica real de envio de SMS aqui
    }
}