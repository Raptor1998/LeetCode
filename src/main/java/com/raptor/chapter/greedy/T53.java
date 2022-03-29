package com.raptor.chapter.greedy;

/**
 * @author raptor
 * @description T53
 * @date 2022/3/29 10:10
 */
public class T53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + nums[i]);
            ans = Math.max(dp[i],ans);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i]+" ");
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new T53().maxSubArray(nums));
    }
}
