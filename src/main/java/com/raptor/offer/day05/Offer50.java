package com.raptor.offer.day05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author raptor
 * @description Offer50
 * @date 2021/12/13 21:13
 */
public class Offer50 {
    public static char firstUniqChar1(String s) {
        Map<Character, Integer> nums = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            nums.put(ch, nums.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (nums.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
    public static char firstUniqChar(String s) {
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars){
            arr[ch -'a'] ++;
        }
        for (char c:chars){
            if (arr[c-'a'] == 1){
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        char c = firstUniqChar(s);
        System.out.println(c);
    }
}
