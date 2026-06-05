package com.utochkin.Dynamic_Programming;

/*
Вам дан целочисленный массив nums, где nums[i] обозначает количество денег в i-м доме.
Дома расположены по кругу, то есть первый и последний дома являются соседними.

Вы планируете ограбить несколько домов, но не можете ограбить два соседних,
потому что система безопасности автоматически вызовет полицию, если будут взломаны оба соседних дома.

Верните максимальную сумму денег, которую вы можете украсть, не привлекая внимания полиции.
*/
public class House_Robber2 {
    // Решение Top-Down
    private static int[][] memo; // хранит memo[i][flag] - текущий индекса i и взяли ли мы ПЕРВЫЙ дом (0 или 1)

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        memo = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            memo[i][0] = -1;
            memo[i][1] = -1;
        }

        return Math.max(dfs(0, 1, nums), dfs(1, 0, nums)); // dfs1: начинаем с дома 0 и считаем, что первый дом взят, dfs2: пропускаем первый дом и начинаем со второго
    }

    private static int dfs(int i, int flag, int[] nums) {
        if (i >= nums.length || (flag == 1 && i == nums.length - 1)) // мы дошли до последнего дома (i == nums.length - 1), но первый дом уже был взят (flag == 1)
            return 0;

        if (memo[i][flag] != -1)
            return memo[i][flag];

        int newFlag = (i == 0) ? 1 : flag;

        memo[i][flag] = Math.max(dfs(i + 1, flag, nums), // не изменяем флаг в первом dfs, т.к. не берем текущий дом. А flag означает: брали ли мы ПЕРВЫЙ дом?
                nums[i] + dfs(i + 2, newFlag, nums));

        return memo[i][flag];
    }


    public static void main(String[] args) {

        int[] nums = {2, 9, 8, 3, 6};

        System.out.println(rob(nums));
    }
}
