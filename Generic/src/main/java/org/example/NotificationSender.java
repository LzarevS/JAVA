package org.example;

import java.util.List;

// NotificationSender interface
public interface NotificationSender<T extends Notification> {
    void send(T notification);
    void send(List<T> notifications);
}
