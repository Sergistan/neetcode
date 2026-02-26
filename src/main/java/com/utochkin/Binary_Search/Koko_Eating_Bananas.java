package com.utochkin.Binary_Search;

import java.util.Arrays;

public class Koko_Eating_Bananas {
    public static void main(String[] args) {

        int[] piles = {25, 10, 23, 4};
        int h = 4;

        System.out.println(minEatingSpeed(piles, h));  // сколько бананов в час можно съесть
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int minEatingSpeed = r;

        while (l <= r) {
            int k = (l + r) / 2;  // скорость поедания бананов

            long totalTime = 0;
            for (int p : piles) {
                totalTime += (long) Math.ceil((double) p / k);
            }

            if (totalTime <= h) {
                minEatingSpeed = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return minEatingSpeed;
    }
}