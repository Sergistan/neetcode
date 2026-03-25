package com.utochkin.Trees;

public class TreeNode7 {
    // Lowest Common Ancestor in Binary Search Tree (Наименьший общий предок в бинарном дереве поиска)
    private int val;
    private TreeNode7 left;
    private TreeNode7 right;

    public TreeNode7() {
    }

    public TreeNode7(int val) {
        this.val = val;
    }

    public TreeNode7(int val, TreeNode7 left, TreeNode7 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode7{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {

        TreeNode7 rootLeftLeftRight = new TreeNode7(2);

        TreeNode7 rootLeftLeft = new TreeNode7(1, null, rootLeftLeftRight);
        TreeNode7 rootLeftRight = new TreeNode7(4);

        TreeNode7 rootRightLeft = new TreeNode7(7);
        TreeNode7 rootRightRight = new TreeNode7(9);

        TreeNode7 rootRight = new TreeNode7(8, rootRightLeft, rootRightRight);
        TreeNode7 rootLeft = new TreeNode7(3, rootLeftLeft, rootLeftRight);

        TreeNode7 root = new TreeNode7(5, rootLeft, rootRight);

        System.out.println(lowestCommonAncestor(root, rootLeftLeftRight, rootLeftRight)); // Предок может быть потомком самого себя // для узлов 2 и 4 наименьший общий предок это 3
        //                         5
        //                       /   \
        //                    3        8
        //                   / \      / \
        //                  1   4    7   9
        //                   \
        //                    2
    }

    public static TreeNode7 lowestCommonAncestor(TreeNode7 root, TreeNode7 p, TreeNode7 q) {
        TreeNode7 node = root;

        while (node != null) {
            if (p.val > node.val && q.val > node.val) {
                node = node.right;
            } else if (p.val < node.val && q.val < node.val) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }
}