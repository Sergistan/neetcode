package com.utochkin.Greedy;
/*
Вам дан целочисленный массив nums, где каждый элемент nums[i] указывает максимальную длину прыжка в этой позиции.
Верните true, если вы можете добраться до последнего индекса, начав с индекса 0, и false в противном случае.
 */
public class Jump_Game {
    public static void main(String[] args) {

        int[] nums = {1,2,0,1,0};

        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int goal = nums.length - 1; // индекс, до которого нам гарантированно нужно добраться.

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) { // Если можно попасть в индекс 3,то из него могу попасть в goal
                goal = i; // меняем новый goal
            }
        }

        return goal == 0; // по итогу должны дойти до начала из конца (прийти в 0 индекс массива)
    }
    // это жадный алгоритм потому что, на каждом шаге принимается локальное решение: Может ли текущая позиция достичь goal?
}
