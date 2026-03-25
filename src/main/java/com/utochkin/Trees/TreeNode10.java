package com.utochkin.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode10 {
    // Count Good Nodes in Binary Tree (Подсчет хороших узлов в бинарном дереве)
    // В бинарном дереве узел x считается хорошим, если путь от корня дерева до узла x не содержит узлов со значением, превышающим значение узла x.
    // То есть мы смотрим всех предков узла. Если среди них нет большего значения, то узел — good. Корень - по умолчанию good узел.
    private int val;
    private TreeNode10 left;
    private TreeNode10 right;

    public TreeNode10() {
    }

    public TreeNode10(int val) {
        this.val = val;
    }

    public TreeNode10(int val, TreeNode10 left, TreeNode10 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode10{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {
        TreeNode10 rootRightLeft = new TreeNode10(1);
        TreeNode10 rootRightRight = new TreeNode10(5);

        TreeNode10 rootLeftLeft = new TreeNode10(3);

        TreeNode10 rootRight = new TreeNode10(1, rootRightLeft, rootRightRight);
        TreeNode10 rootLeft = new TreeNode10(1, rootLeftLeft, null);

        TreeNode10 root = new TreeNode10(2, rootLeft, rootRight);

        System.out.println(goodNodes(root));
        //                         2 <--
        //                       /   \
        //                    1        1
        //                   /        / \
        //                  3 <--    1   5 <--
    }

    public static int goodNodes(TreeNode10 root) {
        int result = 0;

        Queue<TreeNode10> nodeQueue = new LinkedList<>();
        Queue<Integer> maxQueue = new LinkedList<>();

        nodeQueue.add(root);
        maxQueue.add(Integer.MIN_VALUE);

        while (!nodeQueue.isEmpty()) {
            TreeNode10 node = nodeQueue.poll();
            int maxVal = maxQueue.poll();

            if (node.val >= maxVal) {
                result++;
            }

            int newMax = Math.max(maxVal, node.val);

            if (node.left != null) {
                nodeQueue.add(node.left);
                maxQueue.add(newMax);
            }

            if (node.right != null) {
                nodeQueue.add(node.right);
                maxQueue.add(newMax);
            }
        }
        return result;
    }
}