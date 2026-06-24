package com.utochkin.Dynamic_Programming_2D;
/*
Вам даны две строки word1 и word2, каждая из которых состоит из строчных букв английского алфавита.
Вы можете неограниченное количество раз выполнять над word1 три операции:
    вставить символ в любую позицию;
    удалить символ в любой позиции;
    заменить символ в любой позиции.
Верните минимальное количество операций, необходимых для того, чтобы word1 стало равно word2.
 */
public class Edit_Distance {

    private static int[][] dp; // минимальное количество операций, чтобы превратить word1[i...] в word2[j...]

    private static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(0, 0, word1, word2);
    }
    private static int dfs(int i, int j, String word1, String word2) {
        if (i == word1.length()) return word2.length() - j; // Строка word1 закончилась
        if (j == word2.length()) return word1.length() - i; // Строка word2 закончилась
        if (dp[i][j] != -1) return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j)) { // символы совпадают (ничего не делаем т.к. изменять ничего не нужно)
            dp[i][j] = dfs(i + 1, j + 1, word1, word2);
        } else {
            int res = Math.min(dfs(i + 1, j, word1, word2), // delete
                    dfs(i, j + 1, word1, word2)); // insert
            res = Math.min(res, dfs(i + 1, j + 1, word1, word2)); // replace
            dp[i][j] = res + 1; // 1 + стоимость оставшейся части
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        String word1 = "monkeys";
        String word2 = "money";
        System.out.println(minDistance(word1, word2));
    }
}
