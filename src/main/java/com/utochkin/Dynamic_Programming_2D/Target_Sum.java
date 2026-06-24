package com.utochkin.Dynamic_Programming_2D;

import java.util.HashMap;
import java.util.Map;

/*
Вам дан массив целых чисел nums и целое число target.
Для каждого числа в массиве вы можете либо прибавить его к общей сумме, либо вычесть из нее.
Например, если nums = [1, 2], то одна из возможных сумм будет выглядеть так: "+1-2=-1".
Если nums=[1,1], то есть два разных способа сложить входные числа так, чтобы получить в сумме 0: "+1-1" и "-1+1".
Верните количество различных вариантов построения выражения, при которых общая сумма будет равна target.
 */
public class Target_Sum {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2};
        int target = 2;

        System.out.println(findTargetSumWays(nums, target));
    }

    private static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n + 1]; // dp[i] хранит информацию после обработки первых i чисел. Map<Сумма, Количество_Способов>
        for (int i = 0; i <= n; i++) {
            dp[i] = new HashMap<>();
        }
        dp[0].put(0, 1); // сумма 0 получается одним способом (ничего не делать)

        for (int i = 0; i < n; i++) {
            for (Map.Entry<Integer, Integer> entry : dp[i].entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();
                dp[i + 1].put(total + nums[i],
                        dp[i + 1].getOrDefault(total + nums[i], 0) + count);
                dp[i + 1].put(total - nums[i],
                        dp[i + 1].getOrDefault(total - nums[i], 0) + count);
            }
        }
        return dp[n].getOrDefault(target, 0); // dp[n] - все суммы, которые можно получить, используя ВСЕ числа массива
    }
}
