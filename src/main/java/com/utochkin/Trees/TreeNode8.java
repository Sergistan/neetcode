package com.utochkin.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode8 {
    // Binary Tree Level Order Traversal (Обход бинарного дерева в порядке уровней)
    private int val;
    private TreeNode8 left;
    private TreeNode8 right;

    public TreeNode8() {
    }

    public TreeNode8(int val) {
        this.val = val;
    }

    public TreeNode8(int val, TreeNode8 left, TreeNode8 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode8{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {

        TreeNode8 rootLeftLeft = new TreeNode8(4);
        TreeNode8 rootLeftRight = new TreeNode8(5);

        TreeNode8 rootRightLeft = new TreeNode8(6);
        TreeNode8 rootRightRight = new TreeNode8(7);

        TreeNode8 rootRight = new TreeNode8(3, rootRightLeft, rootRightRight);
        TreeNode8 rootLeft = new TreeNode8(2, rootLeftLeft, rootLeftRight);

        TreeNode8 root = new TreeNode8(1, rootLeft, rootRight);

        System.out.println(levelOrder(root));
        //                         1
        //                       /   \
        //                    2        3
        //                   / \      / \
        //                  4   5    6   7
        // Output: [[1],[2,3],[4,5,6,7]]
    }

    public static List<List<Integer>> levelOrder(TreeNode8 root) { // Обход в ширину (по уровням) осуществляется с помощью очередей!
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode8> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            for (int i = queue.size(); i > 0; i--) {
                TreeNode8 node = queue.poll();
                if (node != null) {
                    level.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (!level.isEmpty()) {
                result.add(level);
            }
        }
        return result;
    }
}
