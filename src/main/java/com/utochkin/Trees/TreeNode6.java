package com.utochkin.Trees;

import java.util.Stack;

public class TreeNode6 {
    // Subtree of Another Tree
    private int val;
    private TreeNode6 left;
    private TreeNode6 right;

    public TreeNode6() {
    }

    public TreeNode6(int val) {
        this.val = val;
    }

    public TreeNode6(int val, TreeNode6 left, TreeNode6 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode6{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {

        TreeNode6 rootRightLeft = new TreeNode6(4);
        TreeNode6 rootRightRight = new TreeNode6(5);

        TreeNode6 rootRight = new TreeNode6(3);
        TreeNode6 rootLeft = new TreeNode6(2, rootRightLeft, rootRightRight);

        TreeNode6 root = new TreeNode6(1, rootLeft, rootRight);

        TreeNode6 subRootRight = new TreeNode6(5);
        TreeNode6 subRootLeft = new TreeNode6(4);

        TreeNode6 subRoot = new TreeNode6(2, subRootLeft, subRootRight);

        System.out.println(isSubtree(root, subRoot));
        //        1            2
        //       / \          / \
        //      2   3        4   5
        //     / \
        //    4   5
    }

    public static boolean isSubtree(TreeNode6 root, TreeNode6 subRoot) {
        Stack<TreeNode6> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode6 node = stack.pop();

            if (isSameTree(node, subRoot)) {
                return true;
            }
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return false;
    }

    private static boolean isSameTree(TreeNode6 a, TreeNode6 b) {
        if (a == null && b == null) return true;

        if (a != null && b != null && a.val == b.val)
            return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
        else return false;
    }
}