package com.utochkin.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum { // найти все комбинации чисел, которые дают сумму target
    public static void main(String[] args) {

        int[] nums = {2, 5, 6, 9};
        int target = 9;

        System.out.println(combinationSum(nums, target));
        // [[2, 2, 5], [9]]
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, new ArrayList<>(), 0, nums, target, result);
        return result;
    }

    static void dfs(int i, List<Integer> current, int total, int[] nums, int target, List<List<Integer>> result) {
        if (total == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target) {
                return;
            }
            current.add(nums[j]);
            dfs(j, current, total + nums[j], nums, target, result);
            current.removeLast();
        }
    }
}

