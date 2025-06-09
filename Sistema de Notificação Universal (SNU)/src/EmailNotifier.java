package com.snu.notifier.strategy;

import com.snu.notifier.model.User;

public class EmailNotifier implements NotifierStrategy {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Enviando e-mail para " + user.getEmail() + ": " + message);
        // Lógica real de envio de e-mail aqui
    }
}