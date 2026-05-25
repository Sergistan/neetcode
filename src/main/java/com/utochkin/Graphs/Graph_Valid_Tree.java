package com.utochkin.Graphs;

import java.util.*;

/*
Даны n узлов, пронумерованных от 0 до n - 1, и список неориентированных рёбер (каждое ребро представляет собой пару узлов).
Напишите функцию, которая проверяет, образуют ли эти рёбра корректное дерево.
Граф является деревом если:
- Нет циклов
- Все вершины связаны
т.е. Из любой вершины: можно добраться до любой другой и при этом: нет замкнутых путей
 */
public class Graph_Valid_Tree {
    public static void main(String[] args) {

        int num = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};

        /*
                      3
                      |
                    2-0-1-4
         */

        System.out.println(validTree(num, edges));
    }

    public static boolean validTree(int num, int[][] edges) {
        if (edges.length > num - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>(); // список смежности: коллекция списков, где каждый список соответствует вершине графа и содержит вершины, с которыми она связана.
        for (int i = 0; i < num; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);  // из-за того, что граф ненаправленный
            adj.get(edge[1]).add(edge[0]);  // из-за того, что граф ненаправленный
        }

        Set<Integer> visit = new HashSet<>();
        visit.add(0);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, -1});  // {current node, parent node}


        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int node = pair[0];
            int parent = pair[1];
            for (int nei : adj.get(node)) {
                if (nei == parent) {  // из-за того, что граф ненаправленный
                    continue;
                }
                if (visit.contains(nei)) {
                    return false;
                }
                visit.add(nei);
                q.offer(new int[]{nei, node});
            }
        }

        return visit.size() == num;
    }
}
