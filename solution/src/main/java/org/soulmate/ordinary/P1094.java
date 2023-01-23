package org.soulmate.ordinary;

public class P1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1000];
        int row = trips.length;

        for (int i = 0; i < row; i++) {
            int n = trips[i][0], f = trips[i][1], t = trips[i][2];
            diff[f] += n;
            if (t < diff.length) diff[t] -= n;
        }

        if (diff[0] > capacity) return false;
        for (int i = 1; i < diff.length; i++) {
            diff[i] = diff[i - 1] + diff[i];
            if (diff[i] > capacity) return false;
        }

        return true;
    }
}
