package com.utochkin.Intervals;

import java.util.Arrays;
import java.util.Comparator;

/*
Дан массив интервалов intervals, где intervals[i] = [start_i, end_i]. Верните минимальное количество интервалов, которые нужно удалить, чтобы остальные интервалы не пересекались.
Примечание: интервалы не пересекаются, даже если у них есть общая точка. Например, [1, 3] и [2, 4] пересекаются, а [1, 2] и [2, 3] — нет.
 */
public class Non_overlapping_Intervals {
    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1, 2}, {2, 4}, {1, 4}};

        System.out.println((eraseOverlapIntervals(intervals)));
    }

    public static int eraseOverlapIntervals(int[][] intervals) { // Всегда оставляем интервал с меньшим концом
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int res = 0;
        int prevEnd = intervals[0][1]; // берем конец первого массива как старт

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start >= prevEnd) { // Нет пересечения
                prevEnd = end; // Теперь последним сохраненным интервалом считается текущий
            } else {
                res++;
                prevEnd = Math.min(end, prevEnd);
            }
        }
        return res;
    }
}
