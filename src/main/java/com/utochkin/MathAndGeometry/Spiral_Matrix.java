package com.utochkin.MathAndGeometry;

import java.util.ArrayList;
import java.util.List;

/*
Для заданной матрицы целых чисел размером m x n верните список всех элементов матрицы в спиральном порядке.
 */
public class Spiral_Matrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        System.out.println(spiralOrder(matrix));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length; // left включительно, right НЕ включительно
        int top = 0, bottom = matrix.length; // top включительно, bottom НЕ включительно

        while (left < right && top < bottom) { // Каждая итерация while снимает один слой матрицы
            for (int i = left; i < right; i++) { // Верхняя строка
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i < bottom; i++) { // Правая колонка
                res.add(matrix[i][right - 1]);
            }
            right--;
            if (!(left < right && top < bottom)) { // После удаления верхней строки и правой колонки остался ли ещё хоть один элемент? Если нет — выходим, иначе продолжаем обход нижней строки и левой колонки.
                break;
            }
            for (int i = right - 1; i >= left; i--) { // Нижняя строка справа налево
                res.add(matrix[bottom - 1][i]);
            }
            bottom--;
            for (int i = bottom - 1; i >= top; i--) { // Левая колонка снизу вверх
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }
}
