package org.soulmate.offer;

import java.util.HashMap;

public class I_39 {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int len = nums.length, mid = len / 2;
        for (int i = 0; i < len; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            if (count.get(nums[i]) > mid)
                return nums[i];
        }
        return 0;
    }
}
