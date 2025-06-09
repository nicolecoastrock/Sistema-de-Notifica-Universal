package com.snu.notifier.observer;

import com.snu.notifier.model.User;
import com.snu.notifier.service.NotificationService;

public class UserSubscriber implements NotificationSubscriber {
    private NotificationService notificationService;

    public UserSubscriber(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void update(NotificationEvent event) {
        User user = event.getUser();
        System.out.println("UserSubscriber: Recebendo evento para " + user.getUsername() + " - " + event.getEventType());

        // Exemplo de lógica de filtragem ou preferências específicas do usuário
        if (event.getEventType().equals("PROMOTION") && user.getNotificationPreference().isReceivePromotions()) {
            notificationService.sendNotificationToUser(user, event.getMessage());
        } else if (event.getEventType().equals("ACCOUNT_UPDATE") && user.getNotificationPreference().isReceiveAccountUpdates()) {
            notificationService.sendNotificationToUser(user, event.getMessage());
        }
    }
}