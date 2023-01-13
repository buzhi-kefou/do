package org.soulmate.interview;

import java.util.Arrays;

public class P61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[4];
        for (int i = 3; i >= 0; i--, prev--) {
            int sub = prev - nums[i];
            if (sub == 0)
                return prev == 0 ? true : false;
            if (sub == 1)
                continue;

            if (nums[0] == 0) {
                int j = 0;
                while (j < i) {
                    nums[j] = nums[j + 1];
                    j++;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
