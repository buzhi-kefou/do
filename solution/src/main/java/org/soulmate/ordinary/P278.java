package org.soulmate.ordinary;

public class P278 {

    public int firstBadVersion(int n) {
        int l = 1, r = n, m = (r - l) / 2 + l;

        int prev = 0;
        while (l <= r) {
            if (isBadVersion(m)) {
                prev = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
            m = (r - l) / 2 + l;
        }

        return prev;
    }

    boolean isBadVersion(int version) {
        return true;
    }
}
