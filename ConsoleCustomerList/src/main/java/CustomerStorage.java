import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;
    private static final Logger queryLogger = LogManager.getLogger("queries");
    private static final Logger errorLogger = LogManager.getLogger("errors");

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        try {
            validateData(data);

            final int INDEX_NAME = 0;
            final int INDEX_SURNAME = 1;
            final int INDEX_EMAIL = 2;
            final int INDEX_PHONE = 3;

            String[] components = data.split("\\s+");
            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
            queryLogger.info("Клиент успешно добавлен");
        } catch (RuntimeException e) {
            errorLogger.error("Ошибка при добавлении клиента: " + e.getMessage());
            throw e;
        }
    }


    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        if (storage.containsKey(name)) {
            storage.remove(name);
            queryLogger.info("Клиент '{}' успешно удален.", name);
        } else {
            String errorMessage = "Клиент не найден: " + name;
            errorLogger.error(errorMessage);
            throw new CustomerNotFoundException(errorMessage);
        }
    }

    public Customer getCustomer(String name) {
        if (storage.containsKey(name)) {
            return storage.get(name);
        } else {
            String errorMessage = "Клиент не найден: " + name;
            errorLogger.error(errorMessage);
            throw new CustomerNotFoundException(errorMessage);
        }
    }

    public int getCount() {
        return storage.size();
    }

    private void validateData(String data) {
        String[] components = data.split("\\s+");

        if (components.length != 4) {
            String errorMessage = "Недопустимое количество компонентов в данных: " + data;
            errorLogger.error(errorMessage);
            throw new InvalidDataException(errorMessage);
        }

        String phoneNumber = components[3];
        if (!isValidPhoneNumber(phoneNumber)) {
            String errorMessage = "Неверный формат номера телефона: " + phoneNumber;
            errorLogger.error(errorMessage);
            throw new PhoneNumberFormatException(errorMessage);
        }

        String email = components[2];
        if (!isValidEmail(email)) {
            String errorMessage = "Неверный формат электронной почты: " + email;
            errorLogger.error(errorMessage);
            throw new EmailFormatException(errorMessage);
        }

        queryLogger.info("Данные успешно прошли валидацию: " + data);
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String phoneWithoutPlus = phoneNumber.startsWith("+") ? phoneNumber.substring(1) : phoneNumber;
        return Pattern.matches("\\d{10,}", phoneWithoutPlus);
    }

    private boolean isValidEmail(String email) {
        return Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", email);
    }

    public static class InvalidDataException extends RuntimeException {
        public InvalidDataException(String message) {
            super(message);
        }
    }

    public static class PhoneNumberFormatException extends RuntimeException {
        public PhoneNumberFormatException(String message) {
            super(message);
        }
    }

    public static class EmailFormatException extends RuntimeException {
        public EmailFormatException(String message) {
            super(message);
        }
    }

    public static class CustomerNotFoundException extends RuntimeException {
        public CustomerNotFoundException(String message) {
            super(message);
        }
    }
}