package org.soulmate.ordinary;

public class P303 {

    class NumArray {
        int[] prefix, array;

        public NumArray(int[] nums) {
            prefix = new int[nums.length];
            prefix[0] = nums[0];
            array = nums;
            for (int i = 1; i < nums.length; i++) {
                prefix[i] = nums[i] + prefix[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return prefix[right] - prefix[left] + array[left];
        }
    }
}
