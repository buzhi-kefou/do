package org.soulmate.ordinary;

import java.util.Iterator;

public class P284 {


    class PeekingIterator implements Iterator<Integer> {

        Integer prev;
        Iterator<Integer> ite;

        public PeekingIterator(Iterator<Integer> iterator) {
            ite = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (prev == null)
                prev = ite.next();
            return prev;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (prev == null)
                prev = ite.next();
            Integer res = prev;
            if (ite.hasNext())
                prev = ite.next();
            else
                prev = null;
            return res;
        }

        @Override
        public boolean hasNext() {
            return ite.hasNext() || prev != null;
        }
    }
}
