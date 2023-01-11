package org.soulmate.interview;

import java.util.LinkedList;

public class P59_II {

    class MaxQueue {

        private LinkedList<Integer> queue, deque;

        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }

        public int max_value() {
            return deque.isEmpty() ? -1 : deque.peekFirst();
        }

        public void push_back(int value) {
            queue.addLast(value);
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.pollLast();
            }
            deque.addLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty())
                return -1;
            if (deque.peekFirst().equals(queue.peekFirst()))
                deque.pollFirst();
            return queue.pollFirst();
        }
    }
}