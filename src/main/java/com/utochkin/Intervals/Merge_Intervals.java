package com.utochkin.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Дан массив интервалов, где intervals[i] = [start_i, end_i]. Объедините все перекрывающиеся интервалы и верните массив непересекающихся интервалов, которые охватывают все интервалы из входных данных.
Вы можете возвращать ответ в любом порядке.
Примечание: интервалы не пересекаются, если у них нет общей точки. Например, [1, 2] и [3, 4] не пересекаются, а [1, 2] и [2, 3] пересекаются.
 */
public class Merge_Intervals {
    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1, 3}, {1, 5}, {6, 7}};

        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];

            int[] lastMerged = res.getLast();

            if (current[0] <= lastMerged[1]) {
                lastMerged[1] = Math.max(lastMerged[1], current[1]);
            } else {
                res.add(current);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
