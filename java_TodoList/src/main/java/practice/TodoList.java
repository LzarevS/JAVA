package practice;

import java.util.ArrayList;


public class TodoList {
    ArrayList<String> arrayList = new ArrayList<>();


    public void add(String todo) {
        arrayList.add(todo);
        System.out.println("Добавленно дело \"" + todo + "\"");
        // TODO: добавьте переданное дело в конец списка
    }

    public void add(int index, String todo) {
        if (index <= arrayList.size() && index >= 0) {
            arrayList.add(index, todo);
            System.out.println("Добавленно дело \"" + todo + "\"");
        } else {
            arrayList.add(todo);
        }
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
    }

    public void edit(int index, String todo) {
        if (index <= arrayList.size()) {
            arrayList.set(index, todo);
            System.out.println("Дело " + "\"" + arrayList.get(index) + "заменено на " + "\"" + todo + "\"");
        }

    }
    // TODO: заменить дело на index переданным todo индекс,
    //  проверьте возможность изменения

    public void delete(int index) {
        if (index < arrayList.size()) {
            System.out.println("Дело " + "\"" + arrayList.get(index) + "\"" + " Удаленно");
            arrayList.remove(index);
        } else {
            System.out.println("Дело с таким номером не существует");
        }
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return arrayList;
    }

}
