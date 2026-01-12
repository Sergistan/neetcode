package com.utochkin.Stack;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {

    public static void main(String[] args) {

        String[] tokens = {"1", "2", "+", "3", "*", "4", "-"};  // ((1 + 2) * 3) - 4 = 5

        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                if (stack.isEmpty()) return 0;
                int op1 = stack.pop();
                int op2 = stack.pop();
                int calculation = switch (token) {
                    case "+" -> op2 + op1;
                    case "-" -> op2 - op1;
                    case "*" -> op2 * op1;
                    case "/" -> op2 / op1;
                    default -> throw new IllegalStateException("Unexpected value: " + token);
                };
                stack.push(calculation);
            }
        }
        return stack.pop();
    }
}
