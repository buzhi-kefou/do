package org.soulmate.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class I_59_I {

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < k; i++) {
            queue.add(new int[]{nums[i], i});
        }

        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1, j = 0; i < nums.length; i++, j++) {
            queue.add(new int[]{nums[i], i});

            int[] peek = queue.peek();
            int left = i - k;
            while (peek[1] <= left) {
                queue.poll();
                peek = queue.peek();
            }
            res[j] = peek[0];
        }
        return res;
    }
}
