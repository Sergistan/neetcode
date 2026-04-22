package com.utochkin.Tries;

public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (current.children[i] == null) {
                current.children[i] = new TrieNode();
            }
            current = current.children[i];
        }
        current.endOfWord = true;
    }

    /*
    Возвращает true, если в структуре данных есть строка, соответствующая слову, и false в противном случае. Слово может содержать точки '.', которые могут совпадать с любой буквой.
     */
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode root) {
        TrieNode current = root;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : current.children) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                int ii = c - 'a';
                if (current.children[ii] == null) {
                    return false;
                }
                current = current.children[ii];
            }
        }
        return current.endOfWord;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary  = new WordDictionary();
        wordDictionary.addWord("day");
        wordDictionary.addWord("bay");
        wordDictionary.addWord("may");
        System.out.println(wordDictionary.search("say"));  // return false
        System.out.println(wordDictionary.search("day")); // return true
        System.out.println(wordDictionary.search(".ay")); // return true
        System.out.println(wordDictionary.search("b.."));  // return true
    }
}
