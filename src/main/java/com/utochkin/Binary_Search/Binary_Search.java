package com.utochkin.Binary_Search;

public class Binary_Search {
    public static void main(String[] args) {

        int[] nums = {-1, 0, 2, 4, 5, 6, 8};
        int target = 8;

        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) { // итерируемся до тех пор, пока левая и правая часть не пересеклись
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                low = mid + 1; // смещаем границу low вправо на 1 элемент
            } else {
                high = mid - 1; // смещаем границу high влево на 1 элемент
            }
        }
        return -1; // искомое число не найдено
    }

}
