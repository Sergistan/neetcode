package com.utochkin.Two_Pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum_3 {  //Дан целочисленный массив nums. Верните все тройки [nums[i], nums[j], nums[k]], где nums[i] + nums[j] + nums[k] == 0, а индексы i, j и k различны. В выводе не должно быть повторяющихся троек. Вы можете возвращать вывод и тройки в любом порядке.
    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println((threeSum(nums)));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);   // -4, -1, -1, 0, 1, 2

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else  {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                }
            }
        }
        return list;
    }
}
