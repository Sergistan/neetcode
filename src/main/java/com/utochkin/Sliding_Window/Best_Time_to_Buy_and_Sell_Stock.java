package com.utochkin.Sliding_Window;

public class Best_Time_to_Buy_and_Sell_Stock {

    public static void main(String[] args) {

        int[] prices = {10, 1, 1, 6, 7, 11};

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
}
