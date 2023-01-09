package org.soulmate.offer;

public class I_15 {

    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            cnt += n & 1;
            n >>= 1;
        }
        return cnt;
    }
}
