package practice;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {
    TreeMap<String, String> mapPhoneBook = new TreeMap<>();

    public boolean isName(String input) {
        String regexName = "[А-Яа-я]+";

        return input.matches(regexName);
    }

    public boolean isPhone(String input) {

        String regexPhone = "7[0-9]{10}";

        return input.matches(regexPhone);
    }

    public boolean nameExists(String name) {
        return mapPhoneBook.containsValue(name);
    }

    public boolean phoneExists(String phone) {
        return mapPhoneBook.containsKey(phone);
    }

    public void addContact(String phone, String name) {

        if (isName(name) && isPhone(phone)) {
            mapPhoneBook.put(phone, name);
            System.out.println("Contact ADD");
        } else {
            System.out.println("Number errors ");
        }
    }


    public String getContactByPhone(String phone) {
        String contactByPhone = "";
        for (String key : mapPhoneBook.keySet()) {
            if (phone.equals(key)) {
                contactByPhone = mapPhoneBook.get(key) + " - " + key;
            }
        }
        return contactByPhone;
    }


    public Set<String> getContactByName(String name) {

        TreeSet<String> contact = new TreeSet<>();
        for (String key : mapPhoneBook.keySet()) {
            if (name.equals(mapPhoneBook.get(key))) {
                contact.add(mapPhoneBook.get(key) + " - " + key);
            }

        }
        return contact;
    }

    public Set<String> getAllContacts() {
        TreeMap<String, String> mapForEqualsPhone = new TreeMap<>();
        Set<String> allContacts = new TreeSet<>();

        for (Map.Entry<String, String> entry : mapPhoneBook.entrySet()) {
            if (mapForEqualsPhone.containsKey(entry.getValue())) {
                String contact = mapForEqualsPhone.get(entry.getValue());
                mapForEqualsPhone.put(entry.getValue(), contact.concat(", ").concat(entry.getKey()));
            } else {
                mapForEqualsPhone.put(entry.getValue(), entry.getKey());
            }
        }
        for (String key : mapForEqualsPhone.keySet()) {
            allContacts.add(key + " - " + mapForEqualsPhone.get(key));
        }
        return allContacts;
    }

}
