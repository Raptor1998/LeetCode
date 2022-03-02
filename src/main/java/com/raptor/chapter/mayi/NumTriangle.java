package com.raptor.chapter.mayi;

/**
 * @author raptor
 * @description NumRe
 * @date 2022/3/2 10:20
 */
public class NumTriangle {
    public static int minimumTotal(int[][] triangle) {
        // write your code here
        int n = triangle.length;
        int dp[][] = new int[n][n];
        int maxTotal = triangle[0][0];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j != 0) {
                    dp[i][j] = Math.min(dp[i - 1][j] + triangle[i][j], dp[i - 1][j - 1] + triangle[i][j]);
                } else {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return maxTotal;
    }

    public static void main(String[] args) {
        int[][] a = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };
        System.out.println(minimumTotal(a));
    }
}
