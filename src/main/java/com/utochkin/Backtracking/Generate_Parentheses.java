package com.utochkin.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses { // Вам дано целое число n. Верните все корректные строки из скобок, которые можно составить из n пар скобок.
    public static void main(String[] args) {
        int n = 3;

        System.out.println(generateParenthesis(n));
        // ["((()))","(()())","(())()","()(())","()()()"]
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, result, stack);
        return result;
    }

    static void backtrack(int openN, int closedN, int n, List<String> result, StringBuilder stack) {
        if (openN == closedN && openN == n) {
            result.add(stack.toString());
            return;
        }

        if (openN < n) {
            stack.append('(');
            backtrack(openN + 1, closedN, n, result, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (closedN < openN) {
            stack.append(')');
            backtrack(openN, closedN + 1, n, result, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
