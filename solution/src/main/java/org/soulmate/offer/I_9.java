package org.soulmate.offer;

import java.util.Stack;

public class I_9 {
    class CQueue {
        private Stack<Integer> head;
        private Stack<Integer> tail;

        public CQueue() {
            head = new Stack<>();
            tail = new Stack<>();
        }

        public void appendTail(int value) {
            tail.push(value);
        }

        public int deleteHead() {
            int res = -1;
            if (head.isEmpty()) {
                while (!tail.isEmpty()) {
                    head.push(tail.pop());
                }
            }
            if (!head.isEmpty()) {
                res = head.pop();
            }
            return res;
        }
    }
}
