package com.raptor.chapter.mayi;

/**
 * @author raptor
 * @description NumRe
 * @date 2022/3/2 10:20
 */
public class NumTriangle {
    public static int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        // state: dp[x][y] = minimum path value from 0,0 to x,y
        int n = triangle.length;
        int[][] dp = new int[n][n];

        // initialize 
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        print(dp);

        // top down
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }
        }

        // answer
        int best = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            best = Math.min(best, dp[n - 1][i]);
        }
        return best;
    }

    public static void print(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
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
