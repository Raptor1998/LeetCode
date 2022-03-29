package com.raptor.chapter.string;

/**
 * @author raptor
 * @description T5Sec
 * @date 2022/3/28 21:47
 */
public class T5Sec {
    public String longestPalindrome(String s) {
        int n = s.length();
        int st = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int left = judge(s, i, i);
            int right = judge(s, i, i + 1);
            int max = Math.max(left, right);
            System.out.println("i:" + i + "  max:" + max);
            if (max > end - st) {
                st = i - (max - 1) / 2;
                end = i + (max / 2);
            }
        }
        return s.substring(st, end + 1);
    }

    public int judge(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(new T5Sec().longestPalindrome2(s));
    }
}
