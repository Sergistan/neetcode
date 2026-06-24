package com.utochkin.Dynamic_Programming_2D;

import java.util.Arrays;

/*
Вам дан целочисленный массив coins, в котором содержатся монеты разного номинала (например, 1 доллар, 5 долларов и т. д.), и целое число amount, обозначающее целевую сумму денег.
Верните количество различных комбинаций, сумма которых равна amount.
Если собрать такую сумму невозможно, верните 0. Можно считать, что у вас неограниченное количество монет каждого номинала и что каждое значение в массиве coins уникально.
 */
public class Coin_Change_II {
    public static void main(String[] args) {
        int amount = 4;
        int[] coins = {1, 2, 3};

        System.out.println(change(amount, coins));
    }

    private static int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length + 1][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(0, amount, coins, memo);
    }

    private static int dfs(int i, int amount, int[] coins, int[][] memo) { // Сколько способов собрать сумму amount, используя монеты начиная с индекса i.
        if (amount == 0) return 1;
        if (i >= coins.length) return 0;
        if (memo[i][amount] != -1) return memo[i][amount];

        int res = dfs(i + 1, amount, coins, memo); // не берем текущую монету coins[i]

        if (amount >= coins[i]) {
            res += dfs(i, amount - coins[i], coins, memo); // берем текущую монету coins[i]. уменьшается из-за этого amount, i не изменяется т.к. можно брать монету бесконечно много раз. += т.к. все способы с текущей монетой
        }
        memo[i][amount] = res; // заполняем массив
        return memo[i][amount];
    }
}
