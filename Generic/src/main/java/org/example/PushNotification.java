package org.example;
import lombok.Data;
@Data
public class PushNotification implements Notification {
    private String title;
    private String account;
    private String message;

    public PushNotification(String title, String account, String message) {
        this.title = title;
        this.account = account;
        this.message = message;
    }

    @Override
    public String formatMessage() {
        return "👋 " + message;
    }

    
}