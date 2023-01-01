package org.soulmate.offer;

public class I_57_I {

    public int[] twoSum(int[] nums, int target) {
        int ptrL = 0, ptrR = nums.length - 1, sum;

        while (ptrL < ptrR) {
            sum = nums[ptrL] + nums[ptrR];

            if (sum == target)
                return new int[]{nums[ptrL], nums[ptrR]};
            if (sum > target)
                ptrR--;
            else
                ptrL++;
        }
        return null;
    }
}
