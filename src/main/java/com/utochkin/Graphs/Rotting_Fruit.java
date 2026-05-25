package com.utochkin.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Fruit {
    // Верните минимальное количество минут, которое должно пройти до того, как на поле не останется ни одного свежего фрукта. Если такое состояние невозможно, верните -1.
    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 0},
                {0, 1, 1},
                {0, 1, 2}
        };

        /*
            0 — пустая ячейка
            1 — свежий фрукт
            2 — гнилой фрукт
         */
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }
                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (fresh > 0 && !q.isEmpty()) {
            int length = q.size();  // сколько фруктов гниёт В ЭТУ МИНУТУ (BFS идёт слоями)
            for (int i = 0; i < length; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
