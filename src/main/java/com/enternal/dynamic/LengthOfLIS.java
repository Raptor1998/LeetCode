package com.enternal.dynamic;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/29  19:31
 */
public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
