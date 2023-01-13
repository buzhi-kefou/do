package org.soulmate.interview;

import java.util.Arrays;

public class P45 {

    public String minNumber(int[] nums) {
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            array[i] = String.valueOf(nums[i]);

        Arrays.sort(array, (x, y) -> (x + y).compareTo(y + x));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++)
            sb.append(array[i]);
        return sb.toString();
    }
}
