package org.soulmate.offer;

public class I_42 {

    public int maxSubArray(int[] nums) {
        int len = nums.length, max = -101, sub = 0;

        for (int i = 0; i < len; i++) {
            sub += nums[i];
            if (max < sub)
                max = sub;
            if (sub < 0)
                sub = 0;
        }
        return max;
    }
}
