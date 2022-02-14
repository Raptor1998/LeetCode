package com.raptor.chapter.string;

import sun.rmi.runtime.Log;

/**
 * @author raptor
 * @description T409
 * @date 2022/2/13 19:39
 */
public class T409 {
    public static int longestPalindrome(String s) {
        int[] nums = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                nums[c - 'a']++;
            } else {
                nums[c - 'A' + 26]++;
            }
        }
        int ans = 0;
        int single = 0;
        for (int i = 0; i < 52; i++) {
            if (nums[i] >= 2) {
                ans += ((int) (nums[i] / 2)) * 2;
            }
            if (nums[i] % 2 == 1) {
                single += 1;
            }
        }
        System.out.println("ans: " + ans);
        System.out.println("single: " + single);
        return ans + (single >= 1 ? 1 : 0);
    }

    public static void main(String[] args) {
        String s = "AAAAA";
        int i = longestPalindrome(s);
        System.out.println(i);
    }
}
