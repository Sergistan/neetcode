package com.utochkin.Stack;

import java.util.Arrays;
import java.util.Stack;

public class Daily_Temperatures {
    public static void main(String[] args) {

        int[] temperatures = {30, 38, 30, 36, 35, 40, 28};

        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));  // [1, 4, 1, 2, 1, 0, 0]
    }

    public static int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }
        return result;
    }
}
