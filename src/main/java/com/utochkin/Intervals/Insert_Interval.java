package com.utochkin.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Вам дан массив непересекающихся интервалов intervals, где intervals[i] = [start_i, end_i] представляет время начала и окончания i-го интервала.
Изначально массив intervals отсортирован по возрастанию start_i. Вам дан еще один интервал newInterval = [start, end].

Вставьте newInterval в массив intervals так, чтобы он по-прежнему был отсортирован по возрастанию start_i, а в массиве intervals не было пересекающихся интервалов.
При необходимости вы можете объединить пересекающиеся интервалы.

Верните интервалы после добавления newInterval.

Примечание. Интервалы не пересекаются, если у них нет общей точки. Например, [1,2] и [3,4] не пересекаются, а [1,2] и [2,3] пересекаются.
 */
public class Insert_Interval {
    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1, 2}, {5, 7}, {10, 12}};
        int[] newInterval = new int[]{6, 11};

        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0]) {
                res.add(interval);
            } else if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}
