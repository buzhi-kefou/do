package org.soulmate.offer;

public class I_21 {

    public int[] exchange(int[] nums) {
        int even = nums.length, len = nums.length;

        for (int i = 0; i < even; i++) {
            if ((nums[i] & 1) == 0) {
                int j = --even;
                for (; j > i; j--) {
                    if ((nums[j] & 1) == 1) {
                        swap(nums, i, j);
                        break;
                    }
                }
                if (j == i)
                    break;
                even = j;
            }
        }
        return nums;
    }

    private void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }
}
