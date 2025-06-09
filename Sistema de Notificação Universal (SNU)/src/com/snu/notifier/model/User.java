package com.snu.notifier.model;

public class User {
    private String id;
    private String username;
    private String email;
    private String phoneNumber;
    private String userType; // Ex: "CLIENT", "ADMIN", "PARTNER"
    private NotificationPreference notificationPreference;

    public User(String id, String username, String email, String phoneNumber, String userType, NotificationPreference notificationPreference) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.notificationPreference = notificationPreference;
    }

    // Getters
    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getUserType() { return userType; }
    public NotificationPreference getNotificationPreference() { return notificationPreference; }
}