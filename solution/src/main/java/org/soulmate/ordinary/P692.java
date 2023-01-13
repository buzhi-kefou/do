package org.soulmate.ordinary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P692 {

    static class Trie {
        static class Node {
            Node[] children = new Node[26];
            int val, cnt;
        }

        Node root;

        public Trie() {
            root = new Node();
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Trie.Node[] sort = new Trie.Node[words.length];
        Trie trie = new Trie();

        for (int i = 0; i < words.length; i++) {
            String string = words[i];
            Trie.Node temp = trie.root;
            int len = string.length(), ptr;
            for (int j = 0; j < len; j++) {
                ptr = string.charAt(j) - 'a';
                if (temp.children[ptr] == null)
                    temp.children[ptr] = new Trie.Node();
                temp = temp.children[ptr];
            }
            temp.cnt++;
            temp.val = i;
            sort[i] = temp;
        }

        Arrays.sort(sort, new Comparator<Trie.Node>() {
            @Override
            public int compare(Trie.Node o1, Trie.Node o2) {
                if (o1.cnt == o2.cnt)
                    return words[o1.val].compareTo(words[o2.val]);
                return o2.cnt - o1.cnt;
            }
        });

        String prev = null;
        ArrayList<String> res = new ArrayList<>(k);
        for (int i = 0, j = 0; i < k; i++, j++) {
            String curr = words[sort[j].val];
            if (!curr.equals(prev)) {
                res.add(curr);
                prev = curr;
                continue;
            }
            i--;
        }
        return res;
    }

}
