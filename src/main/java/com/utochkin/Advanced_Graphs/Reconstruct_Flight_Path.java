package com.utochkin.Advanced_Graphs;

import java.util.*;
/*
Есть список билетов: [from, to]
Каждый билет можно использовать только один раз.
Путешествие всегда начинается из:"JFK"
Если возможны несколько маршрутов, нужно вернуть лексикографически минимальный (Сравнение происходит символ за символом слева направо).
 */
public class Reconstruct_Flight_Path {
    public static void main(String[] args) {

        List<List<String>> tickets = new ArrayList<>(List.of(
                List.of("JFK", "SFO"),
                List.of("JFK", "ATL"),
                List.of("SFO", "ATL"),
                List.of("ATL", "JFK"),
                List.of("ATL", "SFO")
        ));

        System.out.println(findItinerary(tickets));
    }
    /*
    алгоритм Хиерхольцер - поиск: Эйлеров путь (путь по всем рёбрам ровно один раз) и используется степени вершин
        Идея алгоритма:
    - Идём по рёбрам, пока можем.
    - Использованные рёбра удаляем.
    - Если из текущей вершины больше некуда идти — добавляем её в ответ.
    - Ответ строится в обратном порядке.
    */
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>(); // Для каждого аэропорта храним все возможные направления. Используем PriorityQueue, чтобы всегда получать лексикографически минимальный аэропорт.
        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        LinkedList<String> res = new LinkedList<>(); //  хранит итоговый маршрут
        Stack<String> stack = new Stack<>(); // хранит текущий путь
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String curr = stack.peek();
            if (!adj.containsKey(curr) || adj.get(curr).isEmpty()) {
                res.addFirst(stack.pop()); // addFirst() потому что вершины добавляются в обратном порядке.
            } else {
                stack.push(adj.get(curr).poll());
            }
        }

        return res;
    }
}