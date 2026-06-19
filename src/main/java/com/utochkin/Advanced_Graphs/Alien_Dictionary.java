package com.utochkin.Advanced_Graphs;

import java.util.*;

/*
Появился новый инопланетный язык, в котором используется английский алфавит, но порядок букв неизвестен.
Вам дан список строк — слов из словаря инопланетного языка. Утверждается, что строки в словах отсортированы лексикографически по правилам этого нового языка.
Если это утверждение неверно и заданное расположение строк в словах не соответствует никакому порядку букв, верните "".
В противном случае верните строку из уникальных букв нового инопланетного языка, отсортированных в лексикографическом порядке по правилам нового языка.
Если существует несколько решений, верните любое из них.

Строка a лексикографически меньше строки b, если выполняется одно из следующих условий:
    -первая различающаяся буква в строке a стоит в алфавите раньше, чем в строке b;
    -строка a является префиксом строки b и a.length < b.length.
 */
public class Alien_Dictionary {
    public static void main(String[] args) {

        String[] words = {"hrn","hrf","er","enn","rfnn"};

        System.out.println(foreignDictionary(words));
    }
/*
Как работает алгоритм Кана (топологическая сортировка)

Основная идея:
    Находим все вершины без входящих рёбер (indegree = 0).
    Добавляем их в очередь.
    Извлекаем вершину из очереди и добавляем её в ответ.
    Удаляем все исходящие рёбра этой вершины.
    Если у какой-то вершины количество входящих рёбер стало равно нулю, добавляем её в очередь.
    Повторяем, пока очередь не опустеет.

    Например:
        a → c
        b → c

        Тогда:
        indegree(a) = 0
        indegree(b) = 0
        indegree(c) = 2

    Буква c не может появиться в ответе раньше a и b.

    Пошаговый пример

    Граф:

    a → c
    b → c
    c → d

    Начальные значения:

    indegree(a) = 0
    indegree(b) = 0
    indegree(c) = 2
    indegree(d) = 1

    Очередь: [a, b]

    Извлекаем a: result = "a"
    Уменьшаем indegree(c): indegree(c) = 1
    Очередь:
    [b]
    Извлекаем b: result = "ab"
    Уменьшаем indegree(c): indegree(c) = 0
    Добавляем c в очередь: [c]
    Извлекаем c: result = "abc"
    Уменьшаем indegree(d): indegree(d) = 0
    Добавляем d: [d]
    Извлекаем d:result = "abcd"
 */
    public static String foreignDictionary(String[] words) { // сравниваем только первое различие в соседних словах (т.к. они отсортированы)
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>(); // количество входящих рёбер

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i]; // сравниваем соседние слова
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) { // Проверка на невалидный случай (В любом лексикографическом порядке более короткое слово должно идти раньше своего продолжения)
                // второе слово является префиксом первого -> w1.substring(0, minLen).equals(w2.substring(0, minLen))
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (!adj.get(w1.charAt(j)).contains(w2.charAt(j))) {
                        adj.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1); // показываем сколько букв должно стоять перед буквой w2.charAt(j)
                    }
                    break; // как только нашли первое различие выходим
                }
            }
        }

        Queue<Character> q = new LinkedList<>(); // Ищем вершины без входящих рёбер
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.offer(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            char letter = q.poll();
            res.append(letter);
            for (char neighbor : adj.get(letter)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    q.offer(neighbor);
                }
            }
        }

        if (res.length() != indegree.size()) { // Если обработали меньше букв, чем существует: в графе есть цикл -> ответа не существует
            return "";
        }

        return res.toString();
    }
}
