package org.soulmate.offer;

public class I_56_I {

    public int[] singleNumbers(int[] nums) {
        int xor = 0, bit = 1;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        for (int i = 0; i < 32; i++, bit <<= 1) {
            if ((xor & bit) > 0) {
                break;
            }
        }

        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & bit) > 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }

        return new int[]{a, b};
    }
}
