package com.raptor.chapter.dy;

import java.util.Arrays;

/**
 * @author raptor
 * @description T718
 * @date 2022/4/7 10:06
 */
public class T718 {
    //最长子序列
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            int s1 = nums1[i - 1];
            for (int j = 1; j <= m; j++) {
                int s2 = nums2[j - 1];
                if (s1 == s2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    //最长子数组  连续
    public int findLength2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int s1 = nums1[i - 1];
            for (int j = 1; j <= m; j++) {
                int s2 = nums2[j - 1];
                if (s1 == s2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 2, 1};
        int[] num2 = {3, 2, 1, 4, 7};
        System.out.println(new T718().findLength2(num1, num2));
    }
}
