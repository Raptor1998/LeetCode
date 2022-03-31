package com.raptor.chapter.string;

/**
 * @author raptor
 * @description T205
 * @date 2022/2/13 20:07
 */
public class T205 {
    public static boolean isIsomorphic(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int[] preIndexOfs = new int[256];
        int[] preIndexOft = new int[256];
        for (int i = 0; i < chars.length; i++) {
            if (preIndexOfs[chars[i]] != preIndexOft[chart[i]]) {
                return false;
            }
            preIndexOfs[chars[i]] = i + 1;
            preIndexOft[chart[i]] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "bbbaaaba";
        String t = "aaabbbab";
        System.out.println(isIsomorphic(s, t));
    }
}
