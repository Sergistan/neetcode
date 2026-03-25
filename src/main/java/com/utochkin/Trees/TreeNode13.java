package com.utochkin.Trees;

import java.util.HashMap;

public class TreeNode13 {
    // Construct Binary Tree from Preorder and Inorder Traversal (Построение бинарного дерева по обходу в прямом и обратном порядке)

    private int val;
    private TreeNode13 left;
    private TreeNode13 right;

    public TreeNode13() {
    }

    public TreeNode13(int val) {
        this.val = val;
    }

    public TreeNode13(int val, TreeNode13 left, TreeNode13 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode13{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {2, 1, 3, 4};

        // preorder (Root → Left → Right)  Первый элемент в preorder — всегда корень
        // inorder (Left → Root → Right)   В inorder: Всё слева от корня → левое поддерево и всё справа → правое поддерево

        System.out.println(buildTree(preorder, inorder));
        //                         1
        //                       /   \
        //                      2     3
        //                             \
        //                              4
    }

    static int preIdx = 0;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static TreeNode13 buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1);
    }

    private static TreeNode13 dfs(int[] preorder, int l, int r) {
        if (l > r) return null;
        int rootVal = preorder[preIdx++];
        TreeNode13 root = new TreeNode13(rootVal);
        int mid = map.get(rootVal);
        root.left = dfs(preorder, l, mid - 1);
        root.right = dfs(preorder, mid + 1, r);
        return root;
    }
}
