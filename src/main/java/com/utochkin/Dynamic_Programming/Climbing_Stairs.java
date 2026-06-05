package com.utochkin.Dynamic_Programming;

/*
Вам дано целое число n, обозначающее количество ступенек, которые нужно преодолеть,
чтобы подняться на самый верх лестницы. Вы можете подниматься по одной или по две ступеньки за раз.

Верните количество различных способов подняться на вершину лестницы.
 */
public class Climbing_Stairs {
    // Решение Bottom-Up
    public static void main(String[] args) {

        int n = 5;

        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1]; // n + 1 чтобы удобно использовать индексы (индекс 0 не используем)

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // dp[i] = количество способов добраться до i-й ступеньки
        }

        return dp[n];
    }
}
