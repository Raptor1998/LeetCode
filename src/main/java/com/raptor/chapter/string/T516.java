package com.raptor.chapter.string;

/**
 * @author raptor
 * @description T516
 * @date 2022/3/29 9:41
 */
public class T516 {

    public int longestPalindromeSubseq(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(s);
        String reverse = stringBuffer.reverse().toString();
        int i = longestCommonSubsequence(s, reverse);
        return i;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char c2 = text2.charAt(j - 1);
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
        System.out.println(new T516().longestPalindromeSubseq("bbbab"));
    }
}
