package com.utochkin.Trees;

public class TreeNode2 {
  //  Maximum Depth of Binary Tree
  private int val;
    private TreeNode2 left;
    private TreeNode2 right;

    public TreeNode2() {
    }

    public TreeNode2(int val) {
        this.val = val;
    }

    public TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode2{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {
        TreeNode2 rightLeft = new TreeNode2(4);
        TreeNode2 left = new TreeNode2(2);
        TreeNode2 right = new TreeNode2(3, rightLeft, null);
        TreeNode2 root = new TreeNode2(1, left, right);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode2 root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
