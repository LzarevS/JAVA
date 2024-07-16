package practice.reverseArray;

import java.util.Arrays;

public class ReverseArray {
    String[] strings;

    public static String[] reverse(String[] strings) {
        //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.

        String[] str = Arrays.copyOf(strings, strings.length);
        for (int i = 0; i < str.length; i++) {
            strings[i] = str[str.length - i - 1];
        }
        return strings;
    }

}