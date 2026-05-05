package com.utochkin.Heap_Priority_Queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class K_Closest_Points_to_Origin {
    public static void main(String[] args) {
        int[][] points = {{0, 2}, {2, 2}, {1, 2}};
        int k = 2;
        System.out.println((Arrays.deepToString(kClosest(points, k))));
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            minHeap.offer(new int[]{dist, point[0], point[1]});
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] point = minHeap.poll();
            result[i] = new int[]{point[1], point[2]};
        }
        return result;
    }
}
