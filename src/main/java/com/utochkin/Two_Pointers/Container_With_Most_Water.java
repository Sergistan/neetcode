package com.utochkin.Two_Pointers;

public class Container_With_Most_Water {

    public static void main(String[] args) {

        int[] heights = {1,7,2,5,4,7,3,6};

        System.out.println(maxArea(heights));
    }

    public static int maxArea(int[] heights) {

        int max = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int heightLeft = heights[left];
            int heightRight = heights[right];

            max = Math.max(max, (right - left) * Math.min(heightLeft, heightRight));

            if (heightLeft < heightRight) {
                left++;
            } else
                right--;
        }

        return max;
    }
}
