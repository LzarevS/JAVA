package practice;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {

        while (true) {

            String message = new Scanner(System.in).nextLine();
            String[] words = message.split("", 3);
            String command = words[0];
            String regex = "[0-9]";
            int index = words[0].matches(regex) ? Integer.parseInt(words[0]) : -1;
            String todo = message.substring(message.indexOf(' ') + 1);

            if (command.equals("ADD")) {
                if (index == -1) {
                    todoList.add(todo);
                } else {
                    todoList.add(index, todo);
                }
            }
            if (command.equals("EDIT")) {
                todoList.edit(index, todo);
            }


            if (command.equals("DELETE")) {
                todoList.delete(index);
            }
            if (command.equals("LIST")) {
                List<String> todos = todoList.getTodos();
                for (int i = 0; i < todos.size(); i++) {
                    System.out.println(i + " - " + todos.get(i));
                }
            }
        }
    }
}

// TODO: написать консольное приложение для работы со списком дел todoList


