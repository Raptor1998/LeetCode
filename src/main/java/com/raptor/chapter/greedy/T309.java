package com.raptor.chapter.greedy;

/**
 * @author raptor
 * @description T309
 * @date 2022/2/17 10:08
 */
public class T309 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int dp[][] = new int[n][3];
        dp[0][0] = 0;    //无股票   不冷冻
        dp[0][1] = -prices[0];   //  持有一股
        dp[0][2] = 0;    //无股票   冷冻
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1] + prices[i];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(Math.max(dp[n - 1][0], dp[n - 1][2]), 0);
    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 0, 2};
        System.out.println(new T309().maxProfit(a));
    }
}
