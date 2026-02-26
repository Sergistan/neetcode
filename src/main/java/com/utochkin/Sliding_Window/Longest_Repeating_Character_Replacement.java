package com.utochkin.Sliding_Window;

import java.util.HashMap;

public class Longest_Repeating_Character_Replacement {
    public static void main(String[] args) {

        String s = "AAABABB";

        int k = 1;

        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        int left = 0;
        int maxFrequency = 0;

        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1); // Добавляем текущий символ в окно
            maxFrequency = Math.max(maxFrequency, map.get(s.charAt(right))); // Обновляем максимальную частоту символа в окне

            while ((right - left + 1) - maxFrequency > k) { // Если нужно больше чем k замен — сжимаем окно слева
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1); // Уменьшаем счётчик
                left++; // Сдвигаем левый край
            }
            result = Math.max(result, right - left + 1); // самая длинная подстрока, содержащая один символ
        }
        return result;
    }
}
