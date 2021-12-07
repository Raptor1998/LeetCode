package com.raptor.base.dayfour;

/**
 * @author raptor
 * @description Solution557
 * @date 2021/12/6 21:27
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class Solution557 {
    public static String reverseWords(String s) {
        String res = "";
        String[] split = s.split(" ");
        for (String s1 : split) {
            res += reverseString(s1.toCharArray()) + " ";
        }
        res = res.substring(0, res.length() - 1);
        return res;
    }

    public static String reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        String res = "";
        for (char c : s) {
            res += c;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }
}
