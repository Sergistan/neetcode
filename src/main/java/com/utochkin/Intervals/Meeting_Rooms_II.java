package com.utochkin.Intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Дан массив объектов с интервалами времени проведения совещаний, состоящих из времени начала и окончания [[start_1,end_1],[start_2,end_2],...] (start_i < end_i).
Найдите минимальное количество комнат, необходимое для проведения всех совещаний без конфликтов.
Примечание: (0,8),(8,10) НЕ считается конфликтом в 8 часов.
 */
public class Meeting_Rooms_II {
    public static class Interval {

        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {

        Interval interval1 = new Interval(0, 40);
        Interval interval2 = new Interval(5, 10);
        Interval interval3 = new Interval(15, 20);

        List<Interval> intervals = new ArrayList<>(List.of(interval1, interval2, interval3));

        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Interval interval : intervals) {
            if (!minHeap.isEmpty() &&  interval.start >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(interval.end);
        }
        return minHeap.size();
    }
}
