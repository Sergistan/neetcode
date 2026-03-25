package com.utochkin.Trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TreeNode4 {
    // Balanced Binary Tree
    private int val;
    private TreeNode4 left;
    private TreeNode4 right;

    public TreeNode4() {
    }

    public TreeNode4(int val) {
        this.val = val;
    }

    public TreeNode4(int val, TreeNode4 left, TreeNode4 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode4{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {

        TreeNode4 rightLeft = new TreeNode4(4);

        TreeNode4 right = new TreeNode4(3, rightLeft, null);
        TreeNode4 left = new TreeNode4(2);

        TreeNode4 root = new TreeNode4(1, left, right);
        System.out.println(isBalanced(root));
        //        1
        //       / \
        //      2   3
        //         /
        //        4
    }

    public static boolean isBalanced(TreeNode4 root) { // Дерево считается сбалансированным, если: Для каждого узла:|высота левого поддерева - высота правого| ≤ 1
        Stack<TreeNode4> stack = new Stack<>();
        Map<TreeNode4, Integer> map = new HashMap<>();
        TreeNode4 node = root; // текущий узел
        TreeNode4 last = null;  // последний полностью обработанный узел

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if (node.right == null || last == node.right) {
                    stack.pop();
                    int left = map.getOrDefault(node.left, 0);
                    int right = map.getOrDefault(node.right, 0);
                    if (Math.abs(left - right) > 1) return false;
                    map.put(node, 1 + Math.max(left, right));
                    last = node;
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }
        return true;
    }
}
