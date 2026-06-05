package com.utochkin.Dynamic_Programming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Для заданной строки s и словаря строк wordDict верните true, если строку s можно разделить на последовательность слов из словаря, разделенных пробелами.
Разрешается использовать слова из словаря неограниченное количество раз. Можно считать, что все слова в словаре уникальны.
 */
public class Word_Break {
    private static Map<Integer, Boolean> memo; // ключ - индекс c которого пытаемся разбить строку до конца строки, значение - true если можно разбить

    public static boolean wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        memo.put(s.length(), true); // базовый случай (если дошли до конца строки, значит успешно разбили всю строку)
        return dfs(s, wordDict, 0);
    }

    private static boolean dfs(String s, List<String> wordDict, int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        for (String w : wordDict) {
            if (i + w.length() <= s.length() && s.startsWith(w, i)) { // s.startsWith(w, i)) -> s.startsWith("leet", 0): проверяет начинается ли строка с позиции 0 на "leet"?
                if (dfs(s, wordDict, i + w.length())) {
                    memo.put(i, true);
                    return true;
                }
            }
        }
        memo.put(i, false);
        return false;
    }

    public static void main(String[] args) {

        String s = "applepenapple";
        List<String> wordDict = List.of("apple", "pen", "ape");

        System.out.println(wordBreak(s, wordDict));
    }
}
