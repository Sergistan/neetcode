package com.utochkin.Dynamic_Programming;

import java.util.Arrays;

/*
Вам дан целочисленный массив nums, где nums[i] обозначает количество денег в i-м доме.
Дома расположены в ряд, то есть i-й дом является соседом (i-1)-го и (i+1)-го домов.

Вы планируете ограбить несколько домов, но не можете ограбить два соседних,
потому что система безопасности автоматически вызовет полицию, если будут взломаны оба соседних дома.

Верните максимальную сумму денег, которую вы можете украсть, не привлекая внимания полиции.
*/
public class House_Robber {
    // Решение Top-Down
    private static int[] memo; // хранит уже вычисленный ответ для dfs(i)

    public static int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(nums, 0);
    }

    private static int dfs(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        memo[i] = Math.max(dfs(nums, i + 1), nums[i] + dfs(nums, i + 2));
        return memo[i]; // максимальная сумма, которую можно украсть, НАЧИНАЯ с дома i и до конца
    }


    public static void main(String[] args) {

        int[] nums = {1, 1, 3, 3};

        System.out.println(rob(nums));
    }
}
