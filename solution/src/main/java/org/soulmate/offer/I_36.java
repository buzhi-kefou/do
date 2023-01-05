package org.soulmate.offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class I_36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node head = null;
    Deque<Node> deque = new ArrayDeque<>();

    public Node treeToDoublyList(Node root) {
        order(root);
        if (deque.isEmpty()) {
            return null;
        } else {
            Node last = deque.pop();
            last.right = head;
            head.left = last;
        }
        return head;
    }

    private void order(Node node) {
        if (node == null)
            return;

        order(node.left);
        if (deque.isEmpty()) {
            deque.push(node);
            head = node;
        } else {
            Node prev = deque.pop();
            prev.right = node;
            node.left = prev;
            deque.push(node);
        }
        order(node.right);
    }
}
