package com.utochkin.Graphs;

import java.util.*;

public class Pacific_Atlantic_Water_Flow {
    public static void main(String[] args) {

        int[][] grid = {
                {4, 2, 7, 3, 4},
                {7, 4, 6, 4, 7},
                {6, 3, 5, 3, 6}
        };

        System.out.println(pacificAtlantic(grid));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        /*
            Pacific - слева и сверху
            Atlantic - справа и снизу
         */

        boolean[][] pacOcean = new boolean[ROWS][COLS]; // клетки из которых можно попасть в Pacific
        boolean[][] atlOcean = new boolean[ROWS][COLS]; // клетки из которых можно попасть в Atlantic

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        for (int c = 0; c < COLS; c++) {
            pacQueue.add(new int[]{0, c});  // Верхняя граница
            atlQueue.add(new int[]{ROWS - 1, c}); // Нижняя граница
        }
        for (int r = 0; r < ROWS; r++) {
            pacQueue.add(new int[]{r, 0}); // Левая граница
            atlQueue.add(new int[]{r, COLS - 1}); // Правая граница
        }

        bfs(pacQueue, pacOcean, heights);
        bfs(atlQueue, atlOcean, heights);

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacOcean[r][c] && atlOcean[r][c]) {  // Клетка достижима: и из Pacific BFS и из Atlantic BFS
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private static void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            ocean[r][c] = true;
            for (int[] d : directions) {
                int row = r + d[0];
                int col = c + d[1];
                if (row >= 0 && row < heights.length && col >= 0 && col < heights[0].length &&
                        !ocean[row][col] && heights[row][col] >= heights[r][c]) { // heights[row][col] >= heights[r][c] -> мы идём обратно(стартуем от океана)
                    q.add(new int[]{row, col});
                }
            }
        }
    }

    /*
        1. Pacific BFS идёт от top/left
        2. Atlantic BFS идёт от bottom/right
        3. BFS идёт только в >= высоты
        4. Пересечение двух visited = ответ
     */
}
