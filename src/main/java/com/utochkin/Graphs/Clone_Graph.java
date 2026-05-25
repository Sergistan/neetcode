package com.utochkin.Graphs;

import java.util.*;

public class Clone_Graph {
     static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }

     }

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> oldToNew = new HashMap<>();
        oldToNew.put(node, new Node(node.val));

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            for (Node neighbors : currentNode.neighbors) {
                if (!oldToNew.containsKey(neighbors)) {
                    oldToNew.put(neighbors, new Node(neighbors.val));
                    queue.add(neighbors);
                }
                oldToNew.get(currentNode).neighbors.add(oldToNew.get(neighbors));
            }
        }
        return oldToNew.get(node);
    }

}
