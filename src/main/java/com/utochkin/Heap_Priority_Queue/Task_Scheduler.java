package com.utochkin.Heap_Priority_Queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Task_Scheduler {
    public static void main(String[] args) {

        char[] tasks = {'X','X','Y','Y'};
        int n = 2;

        System.out.println((leastInterval(tasks, n)));
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // сколько раз ещё можно выполнить задачу
        for (int cnt : count) {
            if (cnt > 0) {
                maxHeap.offer(cnt);
            }
        }
        /* задача проходит следующие состояния:
        1. доступна (heap)
        2. выполняется
        3. уходит в cooldown (queue)
        4. возвращается обратно в heap
         */
        int time = 0;
        Queue<int[]> queue = new LinkedList<>(); // хранит: [count, когда снова можно использовать]
        while (!maxHeap.isEmpty() || !queue.isEmpty()) { // heap → “задачи, которые разрешены” queue → “задачи на перезарядке”
            time++;

            if (maxHeap.isEmpty()) {
                time = queue.peek()[1];
            } else {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    queue.add(new int[]{cnt, time + n});
                }
            }

            if (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.offer(queue.poll()[0]);
            }
        }

        return time;
    }
}
