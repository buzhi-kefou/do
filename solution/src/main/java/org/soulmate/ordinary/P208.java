package org.soulmate.ordinary;

public class P208 {
    static class Trie {
        static class Node {
            Node[] children = new Node[26];
            boolean finish;
            String value;

            public Node() {
            }
        }

        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            char[] array = word.toCharArray();
            Node temp = root;
            int ptr;
            for (int i = 0; i < array.length; i++) {
                ptr = array[i] - 'a';
                if (temp.children[ptr] == null)
                    temp.children[ptr] = new Node();
                temp = temp.children[ptr];
            }
            temp.finish = true;
            temp.value = word;
        }

        public boolean search(String word) {
            char[] chars = word.toCharArray();
            Node temp = root;
            int ptr;
            for (int i = 0; i < chars.length; i++) {
                ptr = chars[i] - 'a';
                if (temp.children[ptr] == null)
                    return false;
                temp = temp.children[ptr];
            }
            return temp.finish;
        }

        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            Node temp = root;
            int ptr;
            for (int i = 0; i < chars.length; i++) {
                ptr = chars[i] - 'a';
                if (temp.children[ptr] == null)
                    return false;
                temp = temp.children[ptr];
            }
            return true;
        }
    }

}
