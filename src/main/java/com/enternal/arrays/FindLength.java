package com.enternal.arrays;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/13  19:26
 */
public class FindLength {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int max = -1;
        for (int i = 1; i <= len1; i++) {
            int temp = nums1[i - 1];
            for (int j = 1; j <= len2; j++) {
                int temp2 = nums2[j - 1];
                if (temp == temp2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 1, 5, 4};
        int[] b = new int[]{6, 2, 1, 5, 0};
        System.out.println(new FindLength().findLength(a, b));
    }
}
