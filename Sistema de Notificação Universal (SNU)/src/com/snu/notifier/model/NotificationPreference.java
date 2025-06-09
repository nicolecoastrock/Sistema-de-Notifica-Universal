package com.snu.notifier.model;

public class NotificationPreference {
    private String preferredChannel; // "email", "sms", "push"
    private boolean receivePromotions;
    private boolean receiveAccountUpdates;
    private boolean receiveSystemAlerts;

    public NotificationPreference(String preferredChannel, boolean receivePromotions, boolean receiveAccountUpdates, boolean receiveSystemAlerts) {
        this.preferredChannel = preferredChannel;
        this.receivePromotions = receivePromotions;
        this.receiveAccountUpdates = receiveAccountUpdates;
        this.receiveSystemAlerts = receiveSystemAlerts;
    }

    // Getters
    public String getPreferredChannel() { return preferredChannel; }
    public boolean isReceivePromotions() { return receivePromotions; }
    public boolean isReceiveAccountUpdates() { return receiveAccountUpdates; }
    public boolean isReceiveSystemAlerts() { return receiveSystemAlerts; }
}
