package com.utochkin.MathAndGeometry;

import java.util.Arrays;

/*
Дана квадратная матрица целых чисел размером n x n.
Поверните ее на 90 градусов по часовой стрелке.
Матрицу нужно повернуть на месте.
Не выделяйте новую двумерную матрицу и не выполняйте поворот.
 */
public class Rotate_Image {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(matrix));
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void rotate(int[][] matrix) {
        int l = 0; // Инициализация границ
        int r = matrix.length - 1;

        while (l < r) {
            for (int i = 0; i < r - l; i++) { // перебираем последовательно все цифры с внешнего слоя к внутреннему. r - l - чтобы один и тот же угол ек обработался дважды
                int top = l;
                int bottom = r;
                // берем 4 соответствующие точки (угловые точки) и вращаем их по кругу
                //сохранили верхний левый
                int topLeft = matrix[top][l + i];

                //переместили нижний левый угол в верхний левый
                matrix[top][l + i] = matrix[bottom - i][l];

                // переместили нижний правый угол в нижний левый
                matrix[bottom - i][l] = matrix[bottom][r - i];

                // переместили верхний правый угол в нижний правый
                matrix[bottom][r - i] = matrix[top + i][r];

                // переместили верхний левый угол в верхний правый
                matrix[top + i][r] = topLeft;
            }
            // чтобы прейти к следующему внутреннему слою сдвигаем границы
            r--;
            l++;
        }
    }
}
