package com.snu.notifier.factory;

import com.snu.notifier.strategy.EmailNotifier;
import com.snu.notifier.strategy.NotifierStrategy;
import com.snu.notifier.strategy.PushNotifier;
import com.snu.notifier.strategy.SMSNotifier;

public class NotifierFactory {
    public static NotifierStrategy createNotifier(String type) {
        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotifier();
            case "sms":
                return new SMSNotifier();
            case "push":
                return new PushNotifier();
            default:
                throw new IllegalArgumentException("Tipo de notificador desconhecido: " + type);
        }
    }
}