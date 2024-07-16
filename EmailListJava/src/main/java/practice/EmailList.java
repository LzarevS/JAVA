package practice;

import java.util.List;
import java.util.TreeSet;

public class EmailList {
    TreeSet<String> treeSetEmail = new TreeSet<>();

    public void add(String email) {
        String regex = "[A-z]+@[A-z]+[.][a-z]{2,4}";

        if (email.matches(regex)) {
            treeSetEmail.add(email.toLowerCase());
        } else {
            System.out.println("WRONG_EMAIL_ANSWER");
        }

        // TODO: валидный формат email добавляется, email это строка, она быть может любой
        // принять решение добавлять аргумент email или нет должен этот метод
    }

    public List<String> getSortedEmails() {
        for (String emails : treeSetEmail) {
            System.out.println(emails);
        }
        // TODO: возвращается сортированный список электронных адресов в алфавитном порядке
        return treeSetEmail.stream().toList();
    }

}
