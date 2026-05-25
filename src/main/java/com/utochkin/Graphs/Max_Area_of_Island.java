package com.utochkin.Graphs;

public class Max_Area_of_Island {
    public static void main(String[] args) {

        int[][] grid = {
                {0, 1, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 0, 1},
                {0, 1, 0, 0, 1}
        };

        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        int areaOfOneCell = 1;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    int area = dfs(grid, r, c, areaOfOneCell);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private static int dfs(int[][] grid, int r, int c, int areaOfOneCell) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;

        int areaDFS1 = dfs(grid, r + 1, c, areaOfOneCell);
        int areaDFS2 = dfs(grid, r - 1, c, areaOfOneCell);
        int areaDFS3 = dfs(grid, r, c + 1, areaOfOneCell);
        int areaDFS4 = dfs(grid, r, c - 1, areaOfOneCell);

        return areaOfOneCell + areaDFS1 + areaDFS2 + areaDFS3 + areaDFS4;
    }
}
