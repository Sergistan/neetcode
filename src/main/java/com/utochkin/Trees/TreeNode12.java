package com.utochkin.Trees;

import java.util.Stack;

public class TreeNode12 {
    // Kth Smallest Integer in BST (K-е наименьшее целое число в двоичном дереве поиска)
    /*
        Правильное бинарное дерево поиска должно соответствовать следующим требованиям:
       1) Левое поддерево каждого узла содержит только узлы с ключами, меньшими, чем ключ самого узла.
       2) Правое поддерево каждого узла содержит только узлы с ключами, большими, чем ключ самого узла.
       3) И левое, и правое поддеревья также являются деревьями двоичного поиска.
    */
    private int val;
    private TreeNode12 left;
    private TreeNode12 right;

    public TreeNode12() {
    }

    public TreeNode12(int val) {
        this.val = val;
    }

    public TreeNode12(int val, TreeNode12 left, TreeNode12 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode12{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {
        TreeNode12 rootLeftLeft = new TreeNode12(2);

        TreeNode12 rootLeft = new TreeNode12(3, rootLeftLeft, null);
        TreeNode12 rootRight = new TreeNode12(5);

        TreeNode12 root = new TreeNode12(4, rootLeft, rootRight);

        System.out.println(kthSmallest(root, 4));
        //                         4
        //                       /   \
        //                      3     5
        //                     /
        //                    2
        // Output: 5
    }

    public static int kthSmallest(TreeNode12 root, int k) {
        Stack<TreeNode12> stack = new Stack<>();
        TreeNode12 current = root;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            k--;
            if (k == 0) {
                return current.val;
            }
            current = current.right;
        }

        return -1;
    }
}
