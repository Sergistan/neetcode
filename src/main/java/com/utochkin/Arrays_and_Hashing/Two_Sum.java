package com.utochkin.Arrays_and_Hashing;

import java.util.Arrays;

public class Two_Sum {
    public static void main(String[] args) {

        int[] nums = {2,3,4,5,6};
        int target = 7;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
