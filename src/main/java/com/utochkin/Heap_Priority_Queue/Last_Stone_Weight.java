package com.utochkin.Heap_Priority_Queue;

import java.util.PriorityQueue;

public class Last_Stone_Weight {
    public static void main(String[] args) {

        int[] stones = {2, 3, 6, 2, 4};

        System.out.println(lastStoneWeight(stones));

    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap  = new PriorityQueue<>();
        for (int stone : stones) {
            minHeap.offer(-stone); // [-6, -4, -3, -2, -2]
        }
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            if (second > first) {
                minHeap.offer(first - second);
            }
        }
        minHeap.offer(0);
        return Math.abs(minHeap.peek());
    }
}
