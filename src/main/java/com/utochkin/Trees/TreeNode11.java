package com.utochkin.Trees;

public class TreeNode11 {
    // Valid Binary Search Tree
    /*
        Правильное бинарное дерево поиска должно соответствовать следующим требованиям:
       1) Левое поддерево каждого узла содержит только узлы с ключами, меньшими, чем ключ самого узла.
       2) Правое поддерево каждого узла содержит только узлы с ключами, большими, чем ключ самого узла.
       3) И левое, и правое поддеревья также являются деревьями двоичного поиска.
    */
    private int val;
    private TreeNode11 left;
    private TreeNode11 right;

    public TreeNode11() {
    }

    public TreeNode11(int val) {
        this.val = val;
    }

    public TreeNode11(int val, TreeNode11 left, TreeNode11 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode11{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {
        TreeNode11 rootLeft = new TreeNode11(2);
        TreeNode11 rootRight = new TreeNode11(3);

        TreeNode11 root = new TreeNode11(1, rootLeft, rootRight);

        System.out.println(isValidBST(root));
        //                         2
        //                       /   \
        //                    1        3
    }

    public static boolean isValidBST(TreeNode11 root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode11 node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) return false;

        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
