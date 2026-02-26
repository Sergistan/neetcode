package com.utochkin.Binary_Search;

public class Search_a_2D_Matrix {
    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 4, 8}, {10, 11, 12, 13}, {14, 20, 30, 40}};
        int target = 12;

        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int start = 0;
        int end = rows - 1;
        while (start <= end) {
            int row = (start + end) / 2;
            if (target > matrix[row][columns - 1]) {
                start = row + 1;
            } else if (target < matrix[row][0]) {
                end = row - 1;
            } else
                break;
        }

        if (!(start <= end)) {
            return false;
        }

        int l = 0;
        int r = columns - 1;
        int row = (start + end) / 2;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (target > matrix[row][mid]) {
                l = mid + 1;
            } else if (target < matrix[row][mid]) {
                r = mid - 1;
            } else
                return true;
        }
        return false;

    }

}













































































