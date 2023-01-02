package org.soulmate.offer;

public class I_53_II {

    public int missingNumber(int[] nums) {
        int right = nums.length - 1, left = 0, mid;

        int res = nums.length;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == mid)
                left = mid + 1;
            else {
                right = mid - 1;
                res = mid;
            }
        }

        return res;
    }
}
