package com.utochkin.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations { // Дан массив nums с уникальными целыми числами. Верните все возможные перестановки. Ответ можно возвращать в любом порядке.
    public static void main(String[] args) {
        int[] nums = {1,2,3};

        System.out.println(permute(nums));
        // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), nums, new boolean[nums.length], result);
        return result;
    }

    static void backtrack(List<Integer> perm, int[] nums, boolean[] pick, List<List<Integer>> result) {
        if (perm.size() == nums.length) {
            result.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                perm.add(nums[i]);
                pick[i] = true;
                backtrack(perm, nums, pick, result);
                perm.removeLast();
                pick[i] = false;
            }
        }
    }
}
