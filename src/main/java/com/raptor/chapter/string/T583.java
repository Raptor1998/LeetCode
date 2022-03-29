package com.raptor.chapter.string;

/**
 * @author raptor
 * @description T583
 * @date 2022/3/29 17:37
 */
public class T583 {

    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int maxSeq = longSamSeq(word1, word2);
        return m + n - maxSeq -maxSeq;
    }

    public static int longSamSeq(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("leetcode", "etco"));
    }
}
