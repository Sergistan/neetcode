package com.utochkin.Dynamic_Programming;
/*
Для заданной строки s найдите количество подстрок в s, которые являются палиндромами.
Палиндром — это строка, которая читается одинаково как слева направо, так и справа налево.
 */
public class Palindromic_Substrings {
    public static void main(String[] args) {

        String s = "aaa";

        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }
}
