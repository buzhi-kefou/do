package org.soulmate.offer;

public class I_50 {

    public char firstUniqChar(String s) {
        int[] counts = new int[26];
        int[] indexes = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            indexes[pos] = i;
            counts[pos]++;
        }
        int ptr = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 1 && ptr > indexes[i])
                ptr = indexes[i];
        }

        return ptr == Integer.MAX_VALUE ? ' ' : s.charAt(ptr);
    }
}
