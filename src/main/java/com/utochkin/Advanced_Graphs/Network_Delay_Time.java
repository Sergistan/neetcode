package com.utochkin.Advanced_Graphs;

import java.util.*;
/*
Есть сеть из n узлов и направленные рёбра между ними.
Каждое ребро задаётся тройкой:
(ui, vi, ti)
где:
ui — откуда отправляется сигнал;
vi — куда приходит сигнал;
ti — время передачи.

Сигнал отправляется из узла k.
Нужно определить, через какое минимальное время сигнал дойдёт до всех узлов.
Если хотя бы один узел недостижим, вернуть -1.
 */
public class Network_Delay_Time {
    public static void main(String[] args) {

        int n = 4;
        int k = 2;
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};

        /*
            2 --1--> 1
            |
            1
            ↓
            3 --1--> 4
         */

        System.out.println(networkDelayTime(times, n, k));
    }
    /*
     алгоритм Дейкстры - поиск кратчайших путей и используется веса вершин/рёбер (строго неотрицательные!)
     Главная идея:
        Алгоритм постепенно расширяет множество вершин, для которых уже известно минимальное расстояние.
        В каждый момент времени выбирается вершина с минимальным известным расстоянием.
     */
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>(); // Строим список смежности: 2 → [(1,1), (3,1)]; 3 → [(4,1)] (номер вершины → [(соседняя_вершина, вес_ребра)])
        for (int[] time : times) {
            edges.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // В куче хранятся пары: [время_до_узла, узел]
        minHeap.offer(new int[]{0, k}); // Добавляем стартовую вершину (время до самого себя равно нулю)

        Set<Integer> visited = new HashSet<>(); // Множество посещённых узлов
        int t = 0; // текущее максимальное время
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int w1 = curr[0];
            int n1 = curr[1];
            if (visited.contains(n1)) { // если узел был обработан ранее, то пропускаем
                continue;
            }
            visited.add(n1);
            t = w1; // последнее значение w1 будет максимальным временем, т.к. узлы извлекаются из кучи в порядке возрастания времени

            if (edges.containsKey(n1)) { // проходим по соседям
                for (int[] next : edges.get(n1)) {
                    int n2 = next[0];
                    int w2 = next[1];
                    if (!visited.contains(n2)) {
                        minHeap.offer(new int[]{w1 + w2, n2});
                    }
                }
            }
        }

        return visited.size() == n ? t : -1; // Если посетили все узлы возвращаем максимальное время t. Иначе некоторые узлы недостижимы.
    }
}
