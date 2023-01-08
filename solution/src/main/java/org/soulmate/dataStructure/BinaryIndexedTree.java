package org.soulmate.dataStructure;

public class BinaryIndexedTree {

    private int[] bit;

    void init(int[] array) {
        for (int i = 1; i < bit.length; i++) {
            update(i, array[i - 1]);
        }
    }

    // bit[i] = ∑(array[i-lowBit(i)+1,...,i]
    void init(int[] array, int[] sum) {
        for (int i = 1; i < array.length; i++) {
            sum[i] = (array[i] + sum[i - 1]);
        }

        for (int i = 1; i < bit.length; i++) {
            bit[i] = sum[i] - sum[i - lowBit(i)];
        }
    }

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
