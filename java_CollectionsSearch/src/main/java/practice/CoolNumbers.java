package practice;

import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        final String[] letters = new String[]{"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        ArrayList<String> list = new ArrayList<>();
        for (String letter : letters) {
            for (int j = 1; j < 10; j++) {
                for (String a : letters) {
                    for (String b : letters) {
                        for (int k = 1; k <= 199; k++) {
                            String region = String.valueOf(k);
                            if (k < 10) {
                                region = "0" + region;
                            }
                            String number = String.format("%s%d%d%d%s%s%s", letter, j, j, j, a, b, region);

                            list.add(number);

                        }
                    }
                }
            }
        }
        return list;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        long start = System.nanoTime();
        boolean search = false;
        if (list.contains(number)) {
            search = true;
            long finish = start - System.nanoTime();
            System.out.println("Поиск перебором: номер найден, поиск занял: " + finish + "нс");
        } else {
            long finish = System.nanoTime() - start;
            System.out.println("Поиск перебором: номер не найден, поиск занял: " + finish + "нс");
        }
        return search;

    }


    public static boolean binarySearchInList(List<String> sortedList, String number) {
        long start = System.nanoTime();
        boolean search = false;
        if (sortedList.contains(number)) {
            search = true;
            long finish = start - System.nanoTime();
            System.out.println("Поиск перебором: номер найден, поиск занял: " + finish + "нс");
        } else {
            long finish = System.nanoTime() - start;
            System.out.println("Поиск перебором: номер не найден, поиск занял: " + finish + "нс");
        }
        return search;

    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        long start = System.nanoTime();
        boolean search = false;
        if (hashSet.contains(number)) {
            search = true;
            long finish = start - System.nanoTime();
            System.out.println("Поиск перебором: номер найден, поиск занял: " + finish + "нс");
        } else {
            long finish = System.nanoTime() - start;
            System.out.println("Поиск перебором: номер не найден, поиск занял: " + finish + "нс");
        }
        return search;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        long start = System.nanoTime();
        boolean search = false;
        if (treeSet.contains(number)) {
            search = true;
            long finish = start - System.nanoTime();
            System.out.println("Поиск перебором: номер найден, поиск занял: " + finish + "нс");
        } else {
            long finish = System.nanoTime() - start;
            System.out.println("Поиск перебором: номер не найден, поиск занял: " + finish + "нс");
        }
        return search;
    }

}

