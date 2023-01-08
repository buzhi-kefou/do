package org.soulmate.ordinary;

import java.util.Arrays;

public class P406 {

    int n;
    int[] tr;
    int[][] ans;

    int lowBit(int x) {
        return x & (-x);
    }

    void add(int x, int v) {
        while (x <= n) {
            tr[x] += v;
            x += lowBit(x);
        }
    }

    int query(int x) {
        int sum = 0;
        while (x > 0) {
            sum += tr[x];
            x -= lowBit(x);
        }
        return sum;
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            else
                return b[1] - a[1];
        });

        n = people.length;
        tr = new int[n + 1];
        ans = new int[n][2];

        for (int[] person : people) {
            int h = person[0], k = person[1];
            int l = 1, r = n;
            while (l < r) {
                int m = (r - l) / 2 + l;
                if (m - query(m) < k + 1) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            ans[r - 1] = person;
            add(r, 1);
        }

        return ans;
    }
}
