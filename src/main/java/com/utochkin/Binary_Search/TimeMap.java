package com.utochkin.Binary_Search;

import java.util.*;

public class TimeMap {
    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);

        int l = 0;
        int r = list.size() - 1;
        String result = "";

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value;
                l = mid + 1;  // ищем более поздний
            } else {
                r = mid - 1;
            }
        }

        return result;
    }

    private static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("alice", "happy", 1);
        timeMap.get("alice", 1);
        timeMap.get("alice", 2);
        timeMap.set("alice", "sad", 3);
        timeMap.get("alice", 3);

    }
}


//    private Map<String, TreeMap<Integer, String>> map;
//
//    public void set(String key, String value, int timestamp) {
//        m.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
//    }
//
//    public String get(String key, int timestamp) {
//        if (!m.containsKey(key)) return "";
//        TreeMap<Integer, String> treeMap = m.get(key);
//        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
//        return entry == null ? "" : entry.getValue();
//    }
