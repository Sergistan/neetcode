package com.utochkin.Graphs;

import java.util.*;

public class Course_Schedule_II {
    public static void main(String[] args) {

        int numCourses = 3;
        int[][] prerequisites = {{1, 0}, {2, 1}}; //  2 -> 1, 1 -> 0

        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();

        for (int[] pair : prerequisites) {
            preMap.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
        }

        List<Integer> output = new ArrayList<>();
        Set<Integer> visit = new HashSet<>(); // лежат курсы которые уже полностью обработаны (проверили, что в них нет цикла)
        Set<Integer> cycle = new HashSet<>();

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, preMap, visit, cycle, output)) {
                return new int[0];
            }
        }

        return output.stream().mapToInt(i -> i).toArray();
    }

    private static boolean dfs(int course, Map<Integer, List<Integer>> prereq, Set<Integer> visit, Set<Integer> cycle, List<Integer> output) {

        if (cycle.contains(course)) {
            return false;
        }
        if (visit.contains(course)) { // уже проверили, что в нет цикла
            return true;
        }

        cycle.add(course);
        for (int pre : prereq.getOrDefault(course, Collections.emptyList())) { //Null Safe
            if (!dfs(pre, prereq, visit, cycle, output)) {
                return false;
            }
        }
        cycle.remove(course);
        visit.add(course);
        output.add(course);
        return true;
    }
}
