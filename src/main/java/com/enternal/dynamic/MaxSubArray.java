package com.enternal.dynamic;

import javafx.scene.chart.Axis;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/29  19:46
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i],dp[i-1] + nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
