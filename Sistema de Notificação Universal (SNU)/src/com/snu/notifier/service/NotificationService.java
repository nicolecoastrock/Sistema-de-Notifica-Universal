package com.snu.notifier.service;

import com.snu.notifier.factory.NotifierFactory;
import com.snu.notifier.model.User;
import com.snu.notifier.strategy.NotifierStrategy;

public class NotificationService {
    private static NotificationService instance;

    private NotificationService() {
        // Construtor privado para impedir instancição externa
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void sendNotificationToUser(User user, String message) {
        String preferredChannel = user.getNotificationPreference().getPreferredChannel();
        NotifierStrategy notifier = NotifierFactory.createNotifier(preferredChannel);
        notifier.sendNotification(user, message);
    }
}