package com.utochkin.Two_Pointers;

public class Trapping_Rain_Water {

    public static void main(String[] args) {

        int[] height = {0, 2, 0, 3, 1, 0, 1, 3, 2, 1};

        System.out.println(trap(height));
    }

    public static int trap(int[] height) {

        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {  // [ 0, 2, 2, 3, 3, 3, 3, 3, 3, 3 ]
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {  // [ 3, 3, 3, 3, 3, 3, 3, 3, 2, 1
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return res;
    }

}
