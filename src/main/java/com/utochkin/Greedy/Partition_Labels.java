package com.utochkin.Greedy;

import java.util.*;

/*
Вам дана строка s, состоящая из строчных букв английского алфавита.
Мы хотим разбить строку на как можно большее количество подстрок так, чтобы каждая буква встречалась не более чем в одной подстроке. То есть одна и та же буква не может оказаться в разных частях.
Верните список целых чисел, соответствующих длине этих подстрок в том порядке, в котором они встречаются в строке.
 */
public class Partition_Labels {
    public static void main(String[] args) {

        String s = "xyxxyzbzbbisl";

        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String s) {
        // Главная идея: Для каждой буквы нужно знать где находится её последнее появление.
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int size = 0; // размер текущей подстроки
        int end = 0; // самый дальний индекс, до которого обязана дойти текущая подстрока
        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, lastIndex.get(s.charAt(i))); // Не режем строку раньше самого последнего появления символа (сохраняем в end максимальный индекс до которого мы должны в последствии дойти)

            if (i == end) { // Это означает: все символы, которые встретились с начала текущей части, больше не появятся дальше
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
