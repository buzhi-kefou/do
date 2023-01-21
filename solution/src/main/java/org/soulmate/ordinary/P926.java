package org.soulmate.ordinary;

public class P926 {

    public int minFlipsMonoIncr(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length, ans = len;

        int[] sum = new int[len + 10];
        for (int i = 1; i <= len; i++)
            sum[i] = sum[i - 1] + (cs[i - 1] - '0');
        for (int i = 1; i <= len; i++) {
            int l = sum[i - 1], r = (len - i) - (sum[len] - sum[i]);
            ans = Math.min(ans, l + r);
        }
        return ans;
    }
}
