package org.soulmate.offer;

import java.util.PriorityQueue;

public class I_41 {

    static class MedianFinder {
        PriorityQueue<Integer> min, max;
        int size;

        public MedianFinder() {
            size = 0;
            this.min = new PriorityQueue<>((x, y) -> x - y);
            this.max = new PriorityQueue<>((x, y) -> y - x);
        }

        public void addNum(int num) {
            if (size % 2 == 0) {
                min.add(num);
                max.add(min.poll());
            } else {
                max.add(num);
                min.add(max.poll());
            }
            size++;
        }

        public double findMedian() {
            if (size % 2 == 0) {
                return (min.peek() + max.peek()) / 2.0;
            } else {
                return max.peek();
            }
        }
    }
}
