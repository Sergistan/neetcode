package com.utochkin.Tries;

public class TrieNode {
    TrieNode[] children = new TrieNode[26]; // каждый узел = одна буква (куда можно пойти дальше по следующей английской букве)
    // children[0] → путь по букве 'a'
    // children[1] → путь по букве 'b' и т.д.
    boolean endOfWord = false;
}
