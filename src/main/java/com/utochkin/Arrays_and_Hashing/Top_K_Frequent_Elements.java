package com.utochkin.Arrays_and_Hashing;

import java.util.*;

public class Top_K_Frequent_Elements {

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3, 3, 3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        return list.stream().limit(k).map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();

//        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k).map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();
    }
}
