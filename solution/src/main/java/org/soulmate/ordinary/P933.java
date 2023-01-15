package org.soulmate.ordinary;

import java.util.LinkedList;

public class P933 {

    class RecentCounter {
        LinkedList<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<Integer>();
        }

        public int ping(int t) {
            queue.addLast(t);
            while (!queue.isEmpty() && t - queue.peekFirst() > 3000)
                queue.removeFirst();
            return queue.size();
        }
    }

}
