package com.utochkin.Binary_Search;

public class Find_Minimum_in_Rotated_Sorted_Array {
    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 6, 1, 2};

        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];

        while (l <= r) {
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
            int mid = l + (r - l) / 2;
            res = Math.min(res, nums[mid]);
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return res;
    }
}