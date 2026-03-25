package com.utochkin.Trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TreeNode3 {
    // Diameter of Binary Tree (найти наибольшее ребро дерево)
    private int val;
    private TreeNode3 left;
    private TreeNode3 right;

    public TreeNode3() {
    }

    public TreeNode3(int val) {
        this.val = val;
    }

    public TreeNode3(int val, TreeNode3 left, TreeNode3 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode3{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {
        TreeNode3 rightLeftLeft = new TreeNode3(5);

        TreeNode3 rightLeft = new TreeNode3(3, rightLeftLeft, null);
        TreeNode3 rightRight = new TreeNode3(4);

        TreeNode3 right = new TreeNode3(2, rightLeft, rightRight);

        TreeNode3 root = new TreeNode3(1, null, right);
        System.out.println(diameterOfBinaryTree(root));
        //        1
        //         \
        //          2
        //         / \
        //        3   4
        //       /
        //      5
    }

    public static int diameterOfBinaryTree(TreeNode3 root) {
        Map<TreeNode3, int[]> map = new HashMap<>();
        map.put(null, new int[]{0, 0}); // {0, 0} - высота поддерева и диаметр поддерева
        Stack<TreeNode3> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode3 node = stack.peek();

            if (node.left != null && !map.containsKey(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !map.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                node = stack.pop();

                int[] leftData = map.get(node.left);
                int[] rightData = map.get(node.right);

                int leftHeight = leftData[0], leftDiameter = leftData[1];
                int rightHeight = rightData[0], rightDiameter = rightData[1];

                int height = 1 + Math.max(leftHeight, rightHeight);
                int diameter = Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));

                map.put(node, new int[]{height, diameter});
            }
        }
        return map.get(root)[1];
    }
}
