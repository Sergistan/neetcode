package com.utochkin.Sliding_Window;

import java.util.HashMap;

public class Permutation_in_String {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bbbca";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> mapS1 = new HashMap<>();
        HashMap<Character, Integer> mapS2 = new HashMap<>();

        int left = 0;
        int windowSize = s1.length();

        for (int i = 0; i < s1.length(); i++) {
            mapS1.put(s1.charAt(i), mapS1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int right = 0; right < s2.length(); right++) {
            mapS2.put(s2.charAt(right), mapS2.getOrDefault(s2.charAt(right), 0) + 1);
            int size = mapS2.values().stream().mapToInt(v -> v).sum();
            if (size == windowSize) {
                if (mapS1.equals(mapS2)) {
                    return true;
                } else {
                    if (mapS2.get(s2.charAt(left)) > 1) {
                        mapS2.put(s2.charAt(left), mapS2.get(s2.charAt(left)) - 1);
                    } else {
                        mapS2.remove(s2.charAt(left));
                    }
                    left++;
                }
            }
        }
        return false;
    }
}
