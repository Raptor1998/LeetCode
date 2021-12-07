package com.raptor.base.dayfour;

/**
 * @author raptor
 * @description Solution344
 * @date 2021/12/6 21:22
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class Solution344 {


    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o','s'};
        reverseString(s);
        for (char c : s) {
            System.out.println(c);
        }
    }
}
