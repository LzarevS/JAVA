package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EmailNotification emailNotification = new EmailNotification("Успешная регистрация!",
                List.of("oleg@java.skillbox.ru", "masha@java.skillbox.ru", "yan@java.skillbox.ru"),
                "Спасибо за регистрацию на сервисе!");

        SmsNotification smsNotification = new SmsNotification(List.of("+70001234567"),
                "Спасибо за регистрацию на сервисе!");

        PushNotification pushNotification = new PushNotification("Успешная регистрация!", "o.yanovich",
                "Спасибо за регистрацию на сервисе!");


        NotificationSender<EmailNotification> emailSender = new EmailNotificationSender();
        NotificationSender<SmsNotification> smsSender = new SmsNotificationSender();
        NotificationSender<PushNotification> pushSender = new PushNotificationSender();


        emailSender.send(emailNotification);
        smsSender.send(smsNotification);
        pushSender.send(pushNotification);
    }
}