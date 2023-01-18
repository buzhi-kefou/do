package org.soulmate.ordinary;

public class P1862 {

    public int sumOfFlooredPairs(int[] nums) {
        int[] cnt = new int[100001], finish = new int[100001];
        int res = 0, len = nums.length;
        for (int i = 0; i < len; i++)
            cnt[nums[i]]++;
        for (int i = 1; i < cnt.length; i++)
            cnt[i] += cnt[i - 1];

        for (int i = 0; i < nums.length; i++) {
            if (finish[nums[i]] == 0) {
                int val = nums[i];
                long valCnt = cnt[val] - cnt[val - 1];
                for (int j = 1; val * j < cnt.length; j++) {
                    int left = val * j, right = val * (j + 1);
                    if (--right >= cnt.length)
                        right = 100000;
                    res = (int) ((res + j * valCnt * (cnt[right] - cnt[left - 1])) % 1000000007);
                }
                finish[val] = 1;
            }
        }
        return res;
    }
}
