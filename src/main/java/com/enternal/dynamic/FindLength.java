package com.enternal.dynamic;

import com.enternal.greddy.MaxProfit;
import javafx.scene.chart.Axis;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/29  19:37
 */
public class FindLength {
    public static int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int tmp1 = nums1[i - 1];
            for (int j = 1; j <= m; j++) {
                int tmp2 = nums2[j - 1];
                if (tmp2 == tmp1) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}
