package com.utochkin.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode9 {
    // Binary Tree Right Side View (Бинарное дерево, вид справа сбоку)
    private int val;
    private TreeNode9 left;
    private TreeNode9 right;

    public TreeNode9() {
    }

    public TreeNode9(int val) {
        this.val = val;
    }

    public TreeNode9(int val, TreeNode9 left, TreeNode9 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode9{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {

        TreeNode9 rootLeftLeftLeft = new TreeNode9(5);

        TreeNode9 rootLeftLeft = new TreeNode9(4, rootLeftLeftLeft, null);

        TreeNode9 rootRight = new TreeNode9(3);
        TreeNode9 rootLeft = new TreeNode9(2, rootLeftLeft, null);

        TreeNode9 root = new TreeNode9(1, rootLeft, rootRight);

        System.out.println(rightSideView(root));
        //                         1 -----
        //                       /   \
        //                    2        3 -----
        //                   /
        //                  4 -----
        //                 /
        //                5 -----
        // Output: [1, 3, 4, 5]
    }

    public static List<Integer> rightSideView(TreeNode9 root) {
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode9> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode9 rightSide = null;

            for (int i = queue.size(); i > 0; i--) {
                TreeNode9 node = queue.poll();
                if (node != null) {
                    rightSide = node;
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (rightSide != null) {
                result.add(rightSide.val);
            }
        }
        return result;
    }
}
