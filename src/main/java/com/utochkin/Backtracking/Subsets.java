package com.utochkin.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets { // Верните все возможные подмножества nums
    public static void main(String[] args) {

        int[] nums = {1, 2};

        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, result);
        return result;
    }

    private static void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> result) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(nums, i + 1, subset, result);
        subset.removeLast();
        dfs(nums, i + 1, subset, result);
    }
}

/*
        дерево решений
             []
         /        \
      [1]          []
     /   \        /   \
 [1,2]  [1]    [2]    []
 */
