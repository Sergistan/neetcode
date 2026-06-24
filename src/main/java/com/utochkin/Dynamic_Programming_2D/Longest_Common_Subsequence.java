package com.utochkin.Dynamic_Programming_2D;

/*
Для двух строк text1 и text2 верните длину самой длинной общей подпоследовательности этих двух строк, если она существует, в противном случае верните 0.
Подпоследовательность — это последовательность, которая может быть получена из исходной последовательности путем удаления некоторых элементов
или без удаления элементов, при этом относительный порядок оставшихся символов не меняется.
Например, «cat» — это подпоследовательность слова «crabt». Общая подпоследовательность двух строк — это подпоследовательность, которая встречается в обеих строках.
 */
public class Longest_Common_Subsequence {

    private static int[][] memo;

    public static int longestCommonSubsequence(String text1, String text2) { // Подпоследовательность получается удалением некоторых символов без изменения порядка остальных
        memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        /*
        Каждая ячейка dp[i][j] означает: LCS для хвостов text1[i:] и text2[j:]
        Именно эту таблицу memo заполняет рекурсивно.
         */
        return dfs(text1, text2, 0, 0);
    }

    private static int dfs(String text1, String text2, int i, int j) { // Какая максимальная длина общей подпоследовательности существует между text1[i:] и text2[j:] То есть между хвостами строк начиная с позиций i и j.
        if (i == text1.length() || j == text2.length()) { // Если одна из строк закончилась, то общая подпоследовательность уже невозможна.
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + dfs(text1, text2, i + 1, j + 1);
        } else { // Когда символы не совпали: Вариант 1: Пропускаем символ первой строки, Вариант 2: Пропускаем символ второй строки. Берём максимум из двух вариантов.
            memo[i][j] = Math.max(dfs(text1, text2, i + 1, j),
                    dfs(text1, text2, i, j + 1));
        }
        return memo[i][j];
    }

    public static void main(String[] args) {

        String text1 = "abcde";
        String text2 = "ace";

        System.out.println(longestCommonSubsequence(text1, text2));
    }
}
