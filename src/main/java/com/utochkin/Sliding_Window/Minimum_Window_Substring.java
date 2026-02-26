package com.utochkin.Sliding_Window;

import java.util.HashMap;

public class Minimum_Window_Substring {
    public static void main(String[] args) {
        String s = "OUZODYXAZV";
        String t = "XYZ";
        System.out.println(minWindow(s, t));  // вернуть самую короткую подстроку s, в которой присутствуют все символы из t, включая повторяющиеся
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0;
        int counter = 0;   // Сколько букв уже закрыто полностью
        int required = need.size();  // Сколько уникальных букв нужно закрыть

        int minLen = Integer.MAX_VALUE;  // длина лучшего окна
        int start = 0;  // начало лучшего найденного окна

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).equals(need.get(c))) {
                counter++;
            }

            while (counter == required) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;  // запоминаем минимальное окно в данной итерации
                    start = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    counter--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
