package com.snu.notifier.observer;

import com.snu.notifier.model.User;
import com.snu.notifier.service.NotificationService;

public class AdminSubscriber implements NotificationSubscriber {
    private NotificationService notificationService;

    public AdminSubscriber(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void update(NotificationEvent event) {
        User user = event.getUser();
        System.out.println("AdminSubscriber: Recebendo evento para " + user.getUsername() + " (ADMIN) - " + event.getEventType());

        // Administradores sempre recebem alertas de sistema
        if (event.getEventType().equals("SYSTEM_ALERT")) {
            notificationService.sendNotificationToUser(user, "ALERTA DE SISTEMA: " + event.getMessage());
        }
        // Podem também receber todos os outros tipos de notificação se desejado
    }
}