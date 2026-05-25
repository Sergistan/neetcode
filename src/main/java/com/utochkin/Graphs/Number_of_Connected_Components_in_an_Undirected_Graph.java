package com.utochkin.Graphs;

import java.util.ArrayList;
import java.util.List;

/*
У вас есть граф из n узлов. Вам дано целое число n и массив edges, где edges[i] = [aᵢ, bᵢ] означает,
что в графе есть ребро между узлами aᵢ и bᵢ. Верните количество компонент связности в графе.

*/
public class Number_of_Connected_Components_in_an_Undirected_Graph {
    public static void main(String[] args) {

        int num = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};

        /*
                      0       3
                      |       |
                      1-2     4
         */

        System.out.println(countComponents(num, edges));
    }

    public static int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visit = new boolean[n];

        int res = 0;
        for (int node = 0; node < n; node++) {
            if (!visit[node]) {
                dfs(adj, visit, node);
                res++;
            }
        }
        return res;
    }

    private static void dfs(List<List<Integer>> adj, boolean[] visit, int node) {
        visit[node] = true;
        for (int nei : adj.get(node)) {
            if (!visit[nei]) {
                dfs(adj, visit, nei);
            }
        }
    }
}
