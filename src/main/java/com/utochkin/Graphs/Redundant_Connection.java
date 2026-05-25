package com.utochkin.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Найти: какое ребро удалить,
чтобы снова получилось дерево
 */
public class Redundant_Connection {
    public static void main(String[] args) {

        int[][] edges = {{1, 2}, {1, 3}, {3, 4}, {2, 4}};

        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) { // Добавляем рёбра по одному и после каждого проверяем появился ли цикл. Если цикл появился - текущее ребро лишнее
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);

            boolean[] visit = new boolean[n + 1];

            if (dfs(u, -1, adj, visit)) {
                return edge;
            }
        }
        return new int[0];
    }

    private static boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visit) {
        if (visit[node]) {
            return true;
        }

        visit[node] = true;
        for (int nei : adj.get(node)) {
            if (nei == parent) {
                continue;
            }
            if (dfs(nei, node, adj, visit)) {
                return true;
            }
        }
        return false;

    }
}
