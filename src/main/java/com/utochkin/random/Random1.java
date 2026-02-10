package com.utochkin.random;

public class Random1 {

    // Написать метод (класс и импорты не нужны) на вход которого приходит две строки.
    // На выходе надо проверить можно ли получить одну строку из другой за 1 исправление:
    // * замена одного символа в одной строке
    // * вставка/удаление одного символа из одной строки
    // Примеры тестовых сценариев:
    //   first = "a", second = "b" -> true
    //   first = "ab", second = "b" -> true
    //   first = "ab", second = "cb" -> true
    //   first = "ab", second = "ba" -> false

    public static void main(String[] args) {

        String str1 = "ab";
        String str2 = "ba";

        System.out.println(isEquals(str1, str2));
    }

    public static boolean isEquals(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }

        if (str1.length() == str2.length()) {
            int diff = 0;
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    diff++;
                    if (diff > 1) return false;
                }
            }
            return true;
        }

        String shorter = str1.length() < str2.length() ? str1 : str2;
        String longer = str1.length() < str2.length() ? str2 : str1;

        int i = 0, j = 0;
        boolean skipped = false;

        while (i < shorter.length() && j < longer.length()) {
            if (shorter.charAt(i) == longer.charAt(j)) {
                i++;
                j++;
            } else {
                if (skipped) return false;
                skipped = true;
                j++;
            }
        }
        return true;
    }
}
