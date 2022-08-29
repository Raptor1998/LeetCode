package com.enternal.string;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/29  11:35
 */
public class ReverseString {
    public static String reverseStr(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(chars, i, Math.min(i + k - 1,n-1));
        }
        return new String(chars);
    }

    public static void reverse(char[] chars, int i, int j) {
        while (i >= 0 && j < chars.length && i < j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 8));
    }
}

