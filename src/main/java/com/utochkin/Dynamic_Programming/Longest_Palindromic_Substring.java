package com.utochkin.Dynamic_Programming;
/*
Для заданной строки s найдите самую длинную подстроку, которая является палиндромом.
Палиндром — это строка, которая читается одинаково как слева направо, так и справа налево.
Если существует несколько палиндромных подстрок одинаковой длины, верните любую из них.
 */
public class Longest_Palindromic_Substring {
    public static void main(String[] args) {

        String s = "ababd";

        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int resIdx = 0; // индекс начала лучшего палиндрома
        int resLen = 0; // длина лучшего палиндрома
        int n = s.length();

        boolean[][] dp = new boolean[n][n]; // хранит является ли s[i...j] палиндромом

        for (int i = n - 1; i >= 0; i--) { // идем справа налево потому что: dp[i][j] зависит от dp[i + 1][j - 1]. А значит нужно сначала вычислить внутреннюю подстроку.
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) { //  j - i <= 2 (строка длины <= 3: i = j ("a"), j - i = 1 ("aa"), j - i = 2 ("aba"))
// dp[i + 1][j - 1] - внутренняя часть тоже палиндром
                    dp[i][j] = true;
                    if (resLen < (j - i + 1)) { // длина подстроки
                        resIdx = i;
                        resLen = j - i + 1;
                    }
                }
            }
        }

        return s.substring(resIdx, resIdx + resLen);
    }
}
