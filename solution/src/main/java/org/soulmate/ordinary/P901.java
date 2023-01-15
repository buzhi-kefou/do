package org.soulmate.ordinary;

import java.util.ArrayDeque;
import java.util.Deque;

public class P901 {

    class StockSpanner {

        int curr = 0;
        Deque<int[]> d = new ArrayDeque<>();

        public int next(int price) {
            while (!d.isEmpty() && d.peekLast()[1] <= price) d.pollLast();
            int prev = d.isEmpty() ? -1 : d.peekLast()[0], ans = curr - prev;
            d.addLast(new int[]{curr++, price});
            return ans;
        }
    }

}
