package org.soulmate.offer;

public class I_46 {

    public int translateNum(int num) {
        String str = String.valueOf(num);
        int len = str.length();

        int[] dp = new int[len + 1];
        dp[0] = dp[1] = 1;

        for (int i = 1; i < len; i++) {
            char a = str.charAt(i - 1), b = str.charAt(i);
            if (a == '1' || (a == '2' && b < 54)) {
                dp[i + 1] = dp[i] + dp[i - 1];
            } else {
                dp[i + 1] = dp[i];
            }
        }
        return dp[len];
    }
}
