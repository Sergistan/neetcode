package com.utochkin.Dynamic_Programming_2D;

import java.util.HashMap;
import java.util.Map;

/*
Вам даны две строки s и t, состоящие из английских букв.
Верните количество различных подпоследовательностей строки s, равных строке t.
Input: s = "caaat", t = "cat"

Output: 3
Объяснение: слово "cat" можно составить из s тремя способами.

(c)aa(at)
(c)a(a)a(t)
(ca)aa(t)
 */
public class Distinct_Subsequences {
    public static void main(String[] args) {
        String s1 = "caaat";
        String s2 = "cat";
        System.out.println(numDistinct(s1, s2));
    }

    private static int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1]; // dp[i][j] - Сколькими способами можно получить t[j...] из s[i...]

        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j]; // Если символы разные
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i + 1][j + 1]; // Если символы одинаковые
                }
            }
        }

        return dp[0][0];
    }
}
