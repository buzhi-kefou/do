package org.soulmate.offer;

public class I_42 {

    public int maxSubArray(int[] nums) {
        int len = nums.length, max = -101, sub = 0;

        for (int i = 0; i < len; i++) {
            sub += nums[i];
            if (max < sub)
                max = sub;
            if (sub < 0)
                sub = 0;
        }
        return max;
    }


    // 分而治之
    int threeMax(int a, int b, int c) {
        return a > b ? (a > c ? a : c) : (b > c ? b : c);
    }

    int func(int[] array, int left, int right) {
        if (left >= right) {
            return array[left];
        }

        int mid = (right - left) / 2 + left;
        int leftMax = func(array, left, mid);
        int rightMax = func(array, mid + 1, right);

        int leftSum = 0, rightSum = 0, borderLeft = -101, borderRight = -101;
        for (int i = mid; i >= left; i--) {
            leftSum += array[i];
            if (borderLeft < leftSum)
                borderLeft = leftSum;
        }
        for (int j = mid + 1; j <= right; j++) {
            rightSum += array[j];
            if (borderRight < rightSum)
                borderRight = rightSum;
        }

        return threeMax(leftMax, rightMax, borderLeft + borderRight);
    }

    int maxSubArray(int[] nums, int numsSize) {
        return func(nums, 0, numsSize - 1);
    }

}
