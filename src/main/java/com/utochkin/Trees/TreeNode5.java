package com.utochkin.Trees;

public class TreeNode5 {
    // Same Binary Tree
    private int val;
    private TreeNode5 left;
    private TreeNode5 right;

    public TreeNode5() {
    }

    public TreeNode5(int val) {
        this.val = val;
    }

    public TreeNode5(int val, TreeNode5 left, TreeNode5 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode5{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {

        TreeNode5 pRight = new TreeNode5(3);
        TreeNode5 pLeft = new TreeNode5(2);

        TreeNode5 p = new TreeNode5(1, pLeft, pRight);

        TreeNode5 qRight = new TreeNode5(3);
        TreeNode5 qLeft = new TreeNode5(2);

        TreeNode5 q = new TreeNode5(1, qLeft, qRight);

        System.out.println(isSameTree(p,q));
        //        1            1
        //       / \          / \
        //      2   3        2   3

    }

    public static boolean isSameTree(TreeNode5 p, TreeNode5 q) {
        if (p == null && q == null) return true;

        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else return false;
    }
}
