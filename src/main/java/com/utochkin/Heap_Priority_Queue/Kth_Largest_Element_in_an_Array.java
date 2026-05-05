package com.utochkin.Heap_Priority_Queue;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {
    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 5, 4};
        int k = 2;

        System.out.println((findKthLargest(nums, k)));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
