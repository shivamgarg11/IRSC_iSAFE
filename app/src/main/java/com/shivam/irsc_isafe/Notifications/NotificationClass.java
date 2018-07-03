package com.shivam.irsc_isafe.Notifications;

public class NotificationClass {

    String notification;
    String notifytime;

    public NotificationClass() {
    }


    public NotificationClass(String notification, String notifytime) {
       this.notification = notification;
        this.notifytime = notifytime;
    }

    public String getNotification() {
        return notification;
    }

    public String getNotifytime() {
        return notifytime;
    }
}
