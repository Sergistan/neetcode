package com.utochkin.Intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Для массива объектов, представляющих интервалы времени встреч, состоящих из времени начала и окончания [[start_1,end_1],[start_2,end_2],...] (start_i < end_i),
определите, может ли человек добавить все встречи в свое расписание без каких-либо конфликтов.
Интервалы могут быть указаны в любом порядке.

Примечание: (0,8),(8,10) не считается конфликтом в 8 часов
 */
public class Meeting_Rooms {

    public static class Interval {

        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {

        Interval interval1 = new Interval(0, 30);
        Interval interval2 = new Interval(5, 10);
        Interval interval3 = new Interval(15, 20);

        List<Interval> intervals = new ArrayList<>(List.of(interval1, interval2, interval3));

        System.out.println(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));

        for (int i = 1; i < intervals.size(); i++) {
            Interval i1 = intervals.get(i - 1);
            Interval i2 = intervals.get(i);

            if (i1.end > i2.start) {
                return false;
            }
        }

        return true;
    }
}
