package org.soulmate.ordinary;

import java.util.Arrays;

public class P720 {

    static class Trie {
        static class Node {
            int length;
            Node parent;
            String value;
            Node[] array = new Node[26];

        }

        Node root = new Node();
    }

    public String longestWord(String[] words) {
        Trie.Node[] sorted = new Trie.Node[words.length];
        Trie trie = new Trie();
        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            Trie.Node temp = trie.root;
            int ptr;
            for (int i = 0; i < word.length(); i++) {
                ptr = word.charAt(i) - 'a';
                if (temp.array[ptr] == null)
                    temp.array[ptr] = new Trie.Node();
                temp.array[ptr].parent = temp;
                temp = temp.array[ptr];
            }
            temp.value = word;
            sorted[j] = temp;
        }

        Arrays.sort(sorted, (x, y) -> {
            if (y.value.length() == x.value.length())
                return x.value.compareTo(y.value);
            return y.value.length() - x.value.length();
        });

        for (int i = 0; i < words.length; i++) {
            Trie.Node node = sorted[i];
            while (node.parent.value != null)
                node = node.parent;
            if (node.parent == trie.root)
                return sorted[i].value;
        }
        return "";
    }
}
