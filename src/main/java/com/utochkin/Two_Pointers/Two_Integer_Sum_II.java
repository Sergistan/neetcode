package com.utochkin.Two_Pointers;

import java.util.Arrays;

public class Two_Integer_Sum_II {

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4};
        int target = 3;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {

        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int curSum = numbers[i] + numbers[j];

            if (curSum > target) {
                j--;
            } else if (curSum < target) {
                i++;
            } else {
                return new int[] { i + 1, j + 1 };
            }
        }
        return new int[0];

    }

}
