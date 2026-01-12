package com.utochkin.Stack;

import java.util.Stack;

public class MinStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }


    public void push(int val) {
        stack.push(val);
        // Если minStack пуст ИЛИ val <= текущему минимуму — добавляем в minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        // Удаляем верхний элемент из основного стека
        int popped = stack.pop();
        // Если удалённый элемент — текущий минимум, удаляем его и из minStack
        if (!minStack.isEmpty() && popped == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(1);
        minStack.push(0);

        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        System.out.println(" ");

        minStack.push(2);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        System.out.println(" ");

        minStack.push(-1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        System.out.println(" ");

        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());

    }

}
