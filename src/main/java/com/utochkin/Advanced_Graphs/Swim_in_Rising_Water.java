package com.utochkin.Advanced_Graphs;

import java.util.*;

/*
Вам дана квадратная двумерная матрица grid, состоящая из различных целых чисел, где каждое целое число grid[i][j] обозначает высоту в точке с координатами (i, j).
Дождь начинается в момент времени t = 0, из-за чего уровень воды поднимается.
В момент времени t уровень воды во всей сетке равен t. Вы можете перемещаться по сетке горизонтально или вертикально между двумя соседними квадратами,
если изначальная высота обоих квадратов меньше или равна уровню воды в момент времени t.
Начиная с верхнего левого квадрата (0, 0), определите минимальное время, за которое можно добраться до нижнего правого квадрата (n - 1, n - 1).
 */
public class Swim_in_Rising_Water {
    public static void main(String[] args) {

        int[][] grid = {{0, 2}, {1, 3}};

        System.out.println(swimInWater(grid));
    }

    public static int swimInWater(int[][] grid) {
        int N = grid.length;
        boolean[][] visit = new boolean[N][N]; // Массив посещённых клеток

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // Вправо, влево, вниз, вверх.

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // [время_достижения, строка, столбец]

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visit[0][0] = true;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int t = curr[0], r = curr[1], c = curr[2];
            if (r == N - 1 && c == N - 1) { // Если дошли до конца
                return t;
            }
            for (int[] dir : directions) { // Обходим соседей
                int neiR = r + dir[0], neiC = c + dir[1];
                if (neiR >= 0 && neiC >= 0 && neiR < N && neiC < N && !visit[neiR][neiC]) { // если мы не вышли за диапазон массива и сосед до этого не был посещен
                    visit[neiR][neiC] = true;
                    minHeap.offer(new int[]{Math.max(t, grid[neiR][neiC]), neiR, neiC}); // вычисляем время достижения соседа Если: текущее время = 4, а высота соседа = 7, то попасть туда можно только в момент: max(4, 7) = 7
                }
            }
        }
        return -1;
    }
}
