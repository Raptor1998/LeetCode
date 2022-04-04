package com.raptor.chapter.fenzhi;

/**
 * @author raptor
 * @description T300
 * @date 2022/4/4 15:23
 */
public class T300 {
    public int lengthOfLIS(int[] s) {
        int n = s.length;
        if (n == 0 || n == 1) {
            return n;
        }
        int dp[] = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int max = -1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (s[i] > s[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);

                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
