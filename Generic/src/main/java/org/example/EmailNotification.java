package org.example;
import lombok.Data;
import java.util.List;
@Data
public class EmailNotification implements Notification {
    private String subject;
    private List<String> receivers;
    private String message;

    public EmailNotification(String subject, List<String> receivers, String message) {
        this.subject = subject;
        this.receivers = receivers;
        this.message = message;
    }

    @Override
    public String formatMessage() {
        return "<p>" + message + "</p>";
    }

}


