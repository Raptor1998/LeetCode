package com.raptor.chapter.string;

import java.lang.management.ThreadInfo;

public class T5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0 || n == 1) {
            return s;
        }
        int left = 0, right = 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (judge(s, i, j)) {
                    if ((j + 1 - i) > (right - left)) {
                        left = i;
                        right = j + 1;
                    }
                }
            }
        }
        return s.substring(left, right);
    }

    public boolean judge(String s, int i, int j) {
        while (i < j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (c1 == c2) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new T5().longestPalindrome("cbc"));
    }
}
