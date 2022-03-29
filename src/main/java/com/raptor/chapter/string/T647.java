package com.raptor.chapter.string;

import com.raptor.chapter.mayi.JumpGame;

/**
 * @author raptor
 * @description T647
 * @date 2022/2/14 10:34
 */
public class T647 {
    public static int countSubstrings(String s) {
        int n = s.length(), l, r;
        int ans = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            l = i / 2;
            r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }

    public static int countSubstrings2(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += judge(s, i, i);
            ans += judge(s, i, i + 1);
        }
        return ans;
    }

    public static int judge(String s, int left, int right) {
        int res = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings2(s));
    }
}
