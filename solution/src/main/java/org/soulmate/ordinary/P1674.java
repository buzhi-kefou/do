package org.soulmate.ordinary;

public class P1674 {

    public int minMoves(int[] nums, int limit) {
        int len = nums.length;
        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < len / 2; i++) {
            int ptr = len - 1 - i, sum;
            int l = 1 + Math.min(nums[i], nums[ptr]), r = limit + Math.max(nums[i], nums[ptr]);

            diff[l] -= 1;
            diff[r + 1] += 1;

            sum = nums[i] + nums[ptr];
            diff[sum + 1] += 1;
            diff[sum] -= 1;
        }

        diff[2] += len;
        len = diff[2];
        for (int i = 3; i < diff.length; i++) {
            diff[i] += diff[i - 1];
            if (len > diff[i]) len = diff[i];
        }
        return len;
    }
}
