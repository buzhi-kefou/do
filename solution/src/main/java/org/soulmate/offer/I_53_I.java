package org.soulmate.offer;

public class I_53_I {

    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return 0;

        int r = nums.length - 1, l = 0, m;
        while (l <= r) {
            m = (r - l) / 2 + l;
            if (nums[m] == target) {
                r = m;
                l = 0;
                while (r >= 0 && nums[r--] == target) {
                    l++;
                }
                r = m + 1;
                while (r < nums.length && nums[r++] == target) {
                    l++;
                }
                break;
            }

            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l <= r ? l : 0;
    }
}
