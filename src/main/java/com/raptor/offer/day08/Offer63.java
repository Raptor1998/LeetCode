package com.raptor.offer.day08;

import java.lang.reflect.Proxy;

/**
 * @author raptor
 * @description Offer63
 * @date 2021/12/22 9:15
 */
public class Offer63 {
    public static int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if ((prices[i] - minPrice) > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int dp[] = new int[prices.length];
        int minPrice = prices[0];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            if ((prices[i] - minPrice) > dp[i - 1]) {
                dp[i] = prices[i] - minPrice;
            } else {
                dp[i] = dp[i - 1];
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        int i = maxProfit(nums);
        System.out.println(i);
    }
}
