package com.raptor.offer.day03;

import java.nio.Buffer;

/**
 * @author raptor
 * @description Offer58
 * @date 2021/12/11 21:09
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class Offer58 {
    public static String reverseLeftWords(String s, int n) {
        //int len = s.length();
        //String front = s.substring(0, n);
        //String end = s.substring(n, len);
        //return end+front;
        int len = s.length();
        StringBuffer buffer = new StringBuffer();
        for (int i = n; i < len; i++) {
            buffer.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            buffer.append(s.charAt(i));
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String s1 = reverseLeftWords(s, k);
        System.out.println(s1);
    }
}
