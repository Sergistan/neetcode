package com.utochkin.Graphs;

import java.util.*;

public class Course_Schedule { // есть ли цикл в графе? (если во время DFS снова попали в текущий путь, то есть цикл)

    private static Map<Integer, List<Integer>> preMap = new HashMap<>(); // Для каждого курса храним: список его prerequisite
    private static Set<Integer> visiting = new HashSet<>(); // курсы в текущем DFS пути

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int course) {
        if (visiting.contains(course)) {
            // Cycle detected
            return false;
        }
        if (preMap.get(course).isEmpty()) {
            return true;
        }

        visiting.add(course);
        for (int pre : preMap.get(course)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visiting.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;
    }

    public static void main(String[] args) {

        int numCourses = 3;
        int[][] prerequisites = {{0, 1}, {1, 2}}; //  2 -> 1, 1 -> 0

        System.out.println(canFinish(numCourses, prerequisites));
    }

}
