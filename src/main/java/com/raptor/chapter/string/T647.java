package com.raptor.chapter.string;

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

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }
}
