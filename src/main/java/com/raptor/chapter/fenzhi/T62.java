package com.raptor.chapter.fenzhi;

public class T62 {
    public static int uniquePaths(int m, int n) {
        int [][] dp = new int[m+1][n+1];
        for (int i = 1; i <=m ; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <=n ; i++) {
            dp[1][i] = 1;
        }
        dp[1][1] = 1;
        for(int i = 2; i <= m;i++){
            for(int j = 2;j<=n;j++){
                dp[i][j] =dp[i][j-1]+dp[i-1][j];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }
}
