package com.utochkin.Tries;

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';  // перевод буквы в индекс массива (пример: 'd' - 'a' = 3)
            if (current.children[i] == null) {
                current.children[i] = new TrieNode();
            }
            current = current.children[i];
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (current.children[i] == null) {
                return false;
            }
            current = current.children[i];
        }
        return current.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (current.children[i] == null) {
                return false;
            }
            current = current.children[i];
        }
        return true;
    }

    public static void main(String[] args) {
        PrefixTree prefixTree = new PrefixTree();
        prefixTree.insert("dog");

        System.out.println(prefixTree.search("dog"));    // return true
        System.out.println(prefixTree.search("do"));    // return false
        System.out.println(prefixTree.startsWith("do")); // return true

        prefixTree.insert("do");

        System.out.println(prefixTree.search("do"));    // return true
    }
}
