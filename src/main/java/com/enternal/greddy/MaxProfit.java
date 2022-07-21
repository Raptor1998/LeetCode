package com.enternal.greddy;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/20  22:08
 */
public class MaxProfit {
    //买卖无限制且只能一次
    public int maxProfit1(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }
            ans = Math.max(prices[i] - minPrice,ans);
        }
        return ans;
    }
    //买卖无限制
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(prices[i]+dp[i-1][1],dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);

        }
        return dp[n-1][0];
    }
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][3];
        dp[0][0] = -prices[0];
        //0 持有一支股票    1 不持有股票在冷冻期   2 不持有股票不在冷冻期
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2] - prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]);
        }
        return Math.max(dp[n-1][1],dp[n-1][2]);
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit3(new int[]{1,2,3,0,2}));
    }
}
