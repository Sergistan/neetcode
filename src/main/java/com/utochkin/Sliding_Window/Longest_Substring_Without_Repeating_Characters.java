package com.utochkin.Sliding_Window;

import java.util.HashSet;

public class Longest_Substring_Without_Repeating_Characters {

    public static void main(String[] args) {

        String s = "zxyzxyz";

        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> window = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (window.contains(c)) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(c);

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
