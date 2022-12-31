package org.soulmate.offer;

public class I_66 {

    public int[] constructArr(int[] a) {
        if (a.length == 0)
            return a;
        int[] L, R;
        L = new int[a.length];
        R = new int[a.length];
        L[0] = R[a.length - 1] = 1;

        for (int i = 1; i < a.length; i++) {
            L[i] = L[i - 1] * a[i - 1];
        }

        for (int i = a.length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * a[i + 1];
        }

        for (int i = 0; i < a.length; i++) {
            L[i] *= R[i];
        }

        return L;
    }
}
