package com.utochkin.Arrays_and_Hashing;

import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence {

    public static void main(String[] args) {
        int[] nums = {-1, -1, 0, 1, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }
                max = Math.max(max, length);
            }
        }
        return max;
    }
}
