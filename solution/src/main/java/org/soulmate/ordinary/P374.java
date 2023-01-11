package org.soulmate.ordinary;

public class P374 {

    public int guessNumber(int n) {
        int l = 1, r = n, m = (r - l) / 2 + l;

        while (l <= r) {
            int res = guess(m);
            if (res == 0) return m;

            if (res > 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
            m = (r - l) / 2 + l;
        }

        return 0;
    }

    int guess(int num) {
        return 0;
    }
}
