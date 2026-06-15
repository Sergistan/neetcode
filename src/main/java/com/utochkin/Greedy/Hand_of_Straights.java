package com.utochkin.Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Вам дан целочисленный массив hand, где hand[i] — значение, записанное на i-й карте, и целое число groupSize.
Вам нужно переставить карты так, чтобы в каждой группе было groupSize карт, а значения на картах увеличивались на 1.
Верните true, если это возможно, и false в противном случае.
 */
public class Hand_of_Straights {
    public static void main(String[] args) {

        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;

        System.out.println(isNStraightHand(hand, groupSize));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
    // жадный выбор - Всегда начинаем новую группу с наименьшей доступной карты!
        Arrays.sort(hand);
        for (int num : hand) {
            if (count.get(num) > 0) { // Эта карта ещё не использована
                for (int i = num; i < num + groupSize; i++) {
                    if (count.getOrDefault(i, 0) == 0) return false;
                    count.put(i, count.get(i) - 1);
                }
            }
        }
        return true;
    }
}
