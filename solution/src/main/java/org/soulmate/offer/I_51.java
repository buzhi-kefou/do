package org.soulmate.offer;

public class I_51 {

    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];

        return mergeSort(nums, temp, 0, nums.length - 1);
    }

    private int mergeSort(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (right - left) / 2 + left;
            int res = mergeSort(array, temp, left, mid) + mergeSort(array, temp, ++mid, right);

            for (int k = left; k <= right; k++)
                temp[k] = array[k];

            int i = left, j = mid;
            for (int k = left; k <= right; k++) {
                if (i == mid) {
                    array[k] = temp[j++];
                } else if (j == right + 1 || temp[i] <= temp[j]) {
                    array[k] = temp[i++];
                } else {
                    array[k] = temp[j++];
                    res += (mid - i);
                }
            }
            return res;
        } else {
            return 0;
        }
    }
}
