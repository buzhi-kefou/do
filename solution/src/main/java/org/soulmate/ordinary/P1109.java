package org.soulmate.ordinary;

public class P1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        int row = bookings.length;
        for (int i = 0; i < row; i++) {
            int l = bookings[i][0], r = bookings[i][1], s = bookings[i][2];
            diff[--l] += s;
            if (r < n) diff[r] -= s;
        }

        for (int i = 1; i < n; i++)
            diff[i] += diff[i - 1];

        return diff;
    }
}
