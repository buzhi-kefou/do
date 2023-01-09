package org.soulmate.offer;

public class I_17 {

    public int[] printNumbers(int n) {
        int size = 1;
        while (n-- >= 1)
            size *= 10;

        int[] res = new int[--size];
        int i = 0, v = 1;
        while (i < size)
            res[i++] = v++;
        return res;
    }
}
