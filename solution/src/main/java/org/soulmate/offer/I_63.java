package org.soulmate.offer;

public class I_63 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int dp[] = new int[prices.length];
        dp[0] = 0;

        int min = prices[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);

            if (min > prices[i])
                min = prices[i];
        }
        return dp[dp.length - 1];
    }
}
