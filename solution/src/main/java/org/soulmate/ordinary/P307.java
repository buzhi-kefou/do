package org.soulmate.ordinary;

public class P307 {

    static class Solution {

        private int[] bit;

        private int lowBit(int idx) {
            return idx & (-idx);
        }

        private int sum(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= lowBit(idx);
            }
            return sum;
        }

        private void update(int idx, int add) {
            while (idx < bit.length) {
                bit[idx] += add;
                idx += lowBit(idx);
            }
        }

        public int findKthLargest(int[] nums, int k) {
            bit = new int[200010];

            for (int i = 0; i < nums.length; i++)
                update(nums[i] + 10001, 1);

            int res = 0, l = 1, r = bit.length - 1;
            while (l < r) {
                int m = (r - l) / 2 + l;

                if (sum(20001) - sum(m) < k) {
                    r = m - 1;
                } else {
                    l = m + 1;
                    res = m;
                }
            }

            return res - 10001;
        }
    }

}
