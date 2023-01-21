package org.soulmate.ordinary;

public class P724 {

    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] suffix = new int[len];
        for (int i = len - 1, j = len; i >= 0; i--, j--) {
            if (j != len) {
                suffix[i] = suffix[j] + nums[i];
            } else {
                suffix[i] = nums[i];
            }
        }

        for (int i = 0; i < len; i++) {
            if (suffix[0] - suffix[i] == suffix[i] - nums[i])
                return i;
        }

        return -1;
    }
}
