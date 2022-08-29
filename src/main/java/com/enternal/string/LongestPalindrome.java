package com.enternal.string;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/24  22:47
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0 || n == 1) {
            return s;
        }
        int max = 0;
        int st = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int left = exp(s, i, i);
            int right = exp(s, i, i + 1);
            max = Math.max(left,right);
            if (max > end - st){
                if (left > right){
                    st = i - (max - 1) / 2;
                    end = i + max / 2;
                }else {
                    st = i - max / 2 + 1;
                    end = i + max / 2;
                }
            }
        }
        return s.substring(st , end + 1);
    }

    public static int exp(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 2 + 1;
    }

    public static void main(String[] args) {
        String babad = new String("cbcd");
        System.out.println(longestPalindrome(babad));
    }

}
