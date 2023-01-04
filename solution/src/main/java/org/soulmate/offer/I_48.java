package org.soulmate.offer;

public class I_48 {

    public int lengthOfLongestSubstring(String s) {
        int[] counts = new int[128];
        int m = 0, l = 0, r = 0, len = s.length();
        for (int i = 0; i < len; i++, r++) {
            char ch = s.charAt(i);
            if (counts[ch] != 0) {
                if (m < r - l)
                    m = r - l;
                for (int j = l; j < r; j++) {
                    if (ch == s.charAt(j)) {
                        l = j + 1;
                        break;
                    }
                }
            } else {
                counts[ch]++;
            }
        }
        return m > r - l ? m : r - l;
    }
}
