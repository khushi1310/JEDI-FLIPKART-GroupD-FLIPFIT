package com.flipkart.bean;


public class FlipFitNotifications {

    private String category; // Category of the notification
    private String message; // Message content of the notification
    private int notificationId; // Unique identifier for the notification


    public int getNotificationId() {
        return notificationId;
    }


    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }
}
