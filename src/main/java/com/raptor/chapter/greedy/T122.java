package com.raptor.chapter.greedy;

/**
 * @author raptor
 * @description T122
 * @date 2022/2/16 9:53
 */
public class T122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
            System.out.println("dp0:" + dp0 + "  dp1:" + dp1);
        }
        return dp0;
    }

    public int maxProfit2(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                ans += prices[i + 1] - prices[i];
            }
        }
        return ans;
    }

    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i][1] = Math.max(dp[i][1], dp[i][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int[] a = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new T122().maxProfit(a));
    }
}
