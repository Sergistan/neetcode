package com.utochkin.Arrays_and_Hashing;

import java.util.Arrays;

public class Products_of_Array_Except_Self {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {   // Префикс — произведение всех элементов слева от текущего -> [1, 1, 2, 6]
            result[i] = result[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {  // Суффикс — произведение всех элементов справа от текущего -> [24, 12, 8, 6]
            result[i] = result[i] * suffix;
            suffix *= nums[i];
        }
        return result;
    }

}
