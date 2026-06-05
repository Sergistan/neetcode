package com.utochkin.Dynamic_Programming;

/*
Есть лестница. Массив: cost[i] означает: сколько стоит наступить на ступеньку i
После оплаты можно: пойти на 1 ступень или на 2 ступени.
Можно стартовать: либо с 0, либо с 1.
Нужно найти: минимальную стоимость добраться до вершины.
Вершина: НЕ входит в массив Она находится: после последнего индекса
 */
public class Min_Cost_Climbing_Stairs {
    // Решение Bottom-Up
    public static void main(String[] args) {

        int[] cost = {1, 2, 3};

        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1]; // минимальная цена добраться до i

        for (int i = 2; i <= n; i++) { // ничего не записываем в dp[0] и dp[1], т.к. можно стартовать с 0 или 1 БЕСПЛАТНО
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]); // dp[i] = минимальная стоимость добраться до ступеньки i
        }

        return dp[n]; // стоимость добраться до ВЕРШИНЫ (за пределы массива)
    }
}
