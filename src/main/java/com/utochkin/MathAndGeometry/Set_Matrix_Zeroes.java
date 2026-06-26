package com.utochkin.MathAndGeometry;

import java.util.Arrays;

/*
Дана матрица целых чисел размером m x n. Если какой-либо элемент равен 0, замените нулями всю его строку и столбец. Матрицу нужно обновить на месте.
 */
public class Set_Matrix_Zeroes {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1}, {1, 0}};
        System.out.println((Arrays.deepToString(matrix)));
        setZeroes(matrix);
        System.out.println((Arrays.deepToString(matrix)));
    }

    private static void setZeroes(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        boolean rowZero = false;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0; // Помечаем столбец
                    if (r > 0) {
                        matrix[r][0] = 0; // Помечаем строку
                    } else {
                        rowZero = true;
                    }
                }
            }
        }
// Начинаем с 1, потому что первая строка и первый столбец заняты маркерами потому что первая строка и первый столбец заняты маркерами
        for (int r = 1; r < ROWS; r++) {
            for (int c = 1; c < COLS; c++) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) { // Обработка первого столбца
            for (int r = 0; r < ROWS; r++) {
                matrix[r][0] = 0;
            }
        }

        if (rowZero) { // Обработка первой строки
            for (int c = 0; c < COLS; c++) {
                matrix[0][c] = 0;
            }
        }
    }
}