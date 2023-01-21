package org.soulmate.ordinary;

public class P238 {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len], prefix = new int[len], suffix = new int[len];

        prefix[0] = nums[0];
        for (int i = 1, j = 0; i < len; i++, j++) {
            prefix[i] = prefix[j] * nums[i];
        }
        suffix[len - 1] = nums[len - 1];
        for (int i = len - 2, j = len - 1; i >= 0; i--, j--) {
            suffix[i] = suffix[j] * nums[i];
        }

        for (int i = 0; i < len; i++) {
            if (i > 0 && i < len - 1) {
                res[i] = prefix[i - 1] * suffix[i + 1];
            } else if (i == len - 1) {
                res[i] = prefix[i - 1];
            } else if (i == 0) {
                res[i] = suffix[i + 1];
            }
        }
        return res;
    }
}
