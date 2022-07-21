package com.enternal.greddy;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/19  22:51
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],dp[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public int maxSubArray2(int[] nums){
        int n = nums.length;
        int [][] dp = new int[n][n];
        dp[0][0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + nums[i];
            max = Math.max(max,dp[0][i]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = dp[i][j-1] + nums[j];
                if (dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray2(new int[]{5,4,-1,7,8}));
    }
}
