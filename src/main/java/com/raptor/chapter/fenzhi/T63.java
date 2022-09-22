package com.raptor.chapter.fenzhi;

public class T63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m-1][n-1]==1){
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        int b = 0;
        for (int i = 1; i <= m; i++) {
            if (obstacleGrid[i-1][0] == 1) {
                b = 1;
            }
            if (b == 0) {
                dp[i][1] = 1;
            } else {
                dp[i][1] = 0;
            }
        }
        b = 0;
        for (int i = 1; i <= n; i++) {
            if (obstacleGrid[0][i-1] == 1) {
                b = 1;
            }
            if (b == 0) {
                dp[1][i] = 1;
            } else {
                dp[1][i] = 0;
            }
        }
        dp[1][1] = 1;
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                if (obstacleGrid[i-1][j - 2] == 0 && obstacleGrid[i - 2][j-1] == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                } else if (obstacleGrid[i-1][j - 2] == 1 && obstacleGrid[i - 2][j-1] == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }

            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] map = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(map));
    }
}
