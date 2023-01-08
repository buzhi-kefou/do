package org.soulmate.offer;

import java.util.ArrayDeque;

public class I_30 {


    class MinStack {
        private ArrayDeque<Integer> stack, min;

        public MinStack() {
            stack = new ArrayDeque<>();
            min = new ArrayDeque<>();
        }

        public void push(int x) {
            if (min.isEmpty() || x < min.peek()) {
                min.push(x);
            } else {
                min.push(min.peek());
            }
            stack.push(x);
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min.peek();
        }
    }
}
