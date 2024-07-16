package practice;

import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    public static final String MENU_INFO = "\nLIST — выводит список электронных адресов;" +
            " \nADD - проверяет и, если формат адреса верный, добавляет в множество;";

    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        EmailList emailList = new EmailList();
        Scanner scanner = new Scanner(System.in);
        boolean isRun = true;
        System.out.println(MENU_INFO);
        while (isRun) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            String[] splitInput = input.split(" ", 2);
            switch (splitInput[0]) {
                case "ADD":
                    emailList.add(splitInput[1]);
                    break;
                case "LIST":
                    emailList.getSortedEmails();
                    break;
                default:
                    System.out.println(WRONG_EMAIL_ANSWER);
            }
        }
    }
    //TODO: write code here

}


