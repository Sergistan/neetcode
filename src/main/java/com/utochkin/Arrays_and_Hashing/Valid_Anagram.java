package com.utochkin.Arrays_and_Hashing;

import java.util.HashMap;

public class Valid_Anagram {

    public static void main(String[] args) {

        String s = "jar";
        String t = "jam";

        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        for (char i : charArrayS) {
            if (mapS.containsKey(i)) {
                mapS.computeIfPresent(i, (a, b) -> b + 1);
            } else {
                mapS.put(i, 1);
            }
        }

        for (char i : charArrayT) {
            if (mapT.containsKey(i)) {
                mapT.computeIfPresent(i, (a, b) -> b + 1);
            } else {
                mapT.put(i, 1);
            }
        }

        return mapS.equals(mapT);
    }

}
