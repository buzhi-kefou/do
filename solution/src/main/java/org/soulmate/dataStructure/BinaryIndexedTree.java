package org.soulmate.dataStructure;

public class BinaryIndexedTree {

    private int[] bit;

    private int lowBit(int idx) {
        return idx & (-idx);
    }

    private int sum(int idx) {
        int sum = 0;
        for (int i = idx; i > 0; i -= lowBit(i)) {
            sum += bit[i];
        }
        return sum;
    }

    private void update(int idx, int val) {
        for (int i = idx; i < bit.length; i += lowBit(i)) {
            bit[i] += val;
        }
    }

    private int singleQuery(int idx) {
        int sum = 0;

        for (int i = idx; i < bit.length; i += lowBit(i)) {
            sum += bit[i];
        }
        return sum;
    }

    private void rangeUpdate(int idx, int val) {
        for (int i = idx; i > 0; i -= lowBit(i)) {
            bit[i] += val;
        }
    }
}
