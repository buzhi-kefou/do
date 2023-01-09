package org.soulmate.offer;

public class I_3 {

    public int findRepeatNumber(int[] nums) {
        boolean[] flag = new boolean[nums.length];

        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            if (flag[temp]) {
                break;
            }
            flag[temp] = true;
        }
        return temp;
    }
}
