package org.soulmate.offer;

public class I_10_II {
    public int numWays(int n) {
        if (n < 2)
            return 1;
        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            b = a + b;
            a = b - a;
            if (b >= 1000000007)
                b %= 1000000007;
        }
        return b;
    }
}
