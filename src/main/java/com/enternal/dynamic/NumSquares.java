package com.enternal.dynamic;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/29  15:14
 */
public class NumSquares {

    public static int numSquares(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(dp[i- j * j] + 1 , min);
            }
            dp[i] = min;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
