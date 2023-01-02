package org.soulmate.offer;

public class I_56_II {

    public int singleNumber(int[] nums) {
        int[] counts = new int[32];

        int bit = 1;
        for (int j = 0; j < 32; j++, bit <<= 1) {
            for (int i = 0; i < nums.length; i++) {
                counts[j] += ((nums[i] & bit) > 0 ? 1 : 0);
            }
        }

        bit = 1;
        int res = 0;
        for (int i = 0; i < 32; i++, bit <<= 1) {
            if (counts[i] % 3 == 1) {
                res |= bit;
            }
        }
        return res;
    }

}
