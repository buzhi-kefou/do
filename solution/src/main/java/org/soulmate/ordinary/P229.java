package org.soulmate.ordinary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P229 {

    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();

        int cnt = nums.length / 3;
        for (int i = 0; i < nums.length; i++) {
            if (i + cnt >= nums.length)
                break;
            int j = i + 1;
            if (nums[i + cnt] == nums[i]) {
                list.add(nums[i]);
                j = i + cnt;
            }
            while (j < nums.length && nums[i] == nums[j])
                j++;
            i = j - 1;
        }

        return list;
    }

}
