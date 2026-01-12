package com.utochkin.Arrays_and_Hashing;

import java.util.*;

public class Group_Anagrams {
    public static void main(String[] args) {

        String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};

        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> listOutput = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            boolean alreadyUsed = false;

            for (List<String> group : listOutput) {
                if (group.contains(strs[i])) {
                    alreadyUsed = true;
                    break;
                }
            }
            if (alreadyUsed) {
                continue;
            }

            List<String> listInput = new ArrayList<>();
            listInput.add(strs[i]);

            HashMap<Character, Integer> mapI = new HashMap<>();
            char[] charArraySI = strs[i].toCharArray();

            for (char ii : charArraySI) {
                if (mapI.containsKey(ii)) {
                    mapI.computeIfPresent(ii, (a, b) -> b + 1);
                } else {
                    mapI.put(ii, 1);
                }
            }
            for (int j = i + 1; j < strs.length; j++) {

                HashMap<Character, Integer> mapJ = new HashMap<>();

                char[] charArraySJ = strs[j].toCharArray();

                for (char jj : charArraySJ) {
                    if (mapJ.containsKey(jj)) {
                        mapJ.computeIfPresent(jj, (a, b) -> b + 1);
                    } else {
                        mapJ.put(jj, 1);
                    }
                }
                if (mapI.equals(mapJ)) {
                    listInput.add(strs[j]);
                }
            }
            listOutput.add(listInput);
        }
        return listOutput;
    }


//    public static List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map = new HashMap<>();
//
//        for (String word : strs) {
//            char[] chars = word.toCharArray();
//            Arrays.sort(chars);
//            String sortedWord = new String(chars);
//
//            if (!map.containsKey(sortedWord)) {
//                map.put(sortedWord, new ArrayList<>());
//            }
//
//            map.get(sortedWord).add(word);
//        }
//
//        return new ArrayList<>(map.values());
//    }
//}

}

