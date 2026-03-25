package com.utochkin.Trees;

public class TreeNode {
// Invert Binary Tree
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);

        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7);

        TreeNode left = new TreeNode(2, leftLeft, leftRight);
        TreeNode right = new TreeNode(3, rightLeft, rightRight);

        TreeNode root = new TreeNode(1, left, right);
        System.out.println(root);

        System.out.println(invertTree(root));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
