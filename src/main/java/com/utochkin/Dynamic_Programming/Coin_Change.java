package com.utochkin.Dynamic_Programming;

import java.util.Arrays;

/*
Вам дан целочисленный массив coins, в котором содержатся монеты разного номинала (например, 1 доллар, 5 долларов и т. д.), и целое число amount, обозначающее целевую сумму денег.
Верните наименьшее количество монет, которое необходимо, чтобы набрать точную целевую сумму.
Если набрать нужную сумму невозможно, верните -1. Можно считать, что у вас неограниченное количество монет каждого номинала.
 */
public class Coin_Change {
    public static void main(String[] args) {

        int[] coin = {1, 5, 10};
        int amount = 12;

        System.out.println(coinChange(coin, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // amount + 1 потому что это значение заведомо больше любого возможного ответа
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) { // dp[i]=минимальное количество монет для получения суммы i (заполняем dp)
            for (int j = 0; j < coins.length; j++) { // перебираем для каждого индекса(amount) монеты
                if (coins[j] <= i) { // если монета меньше или равна amount
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    /*
                    dp[i - coin] + 1
                    Я беру монету coin последней. До нее мне нужно было собрать сумму (i - coin).
                    Это уже известно и хранится в dp[i - coin].
                    Добавляю текущую монету.
                    Поэтому +1 (это не число, а +1 монета)
                     */
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount]; // проверка если собрать сумму amount невозможно

    }
}