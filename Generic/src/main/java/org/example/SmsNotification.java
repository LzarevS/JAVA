package org.example;
import lombok.Data;
import java.util.List;
@Data
public class SmsNotification implements Notification {
    private String phoneNumbers;
    private String message;

    public SmsNotification(List<String> phoneNumbers, String message) {
        this.phoneNumbers = phoneNumbers.toString();
        this.message = message;
    }


    @Override
    public String formatMessage() {
        return message;
    }

}