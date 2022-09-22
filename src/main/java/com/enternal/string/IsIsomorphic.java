package com.enternal.string;

public class IsIsomorphic {

    public static boolean isIsomorphic(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[] preIndex1 = new int[256];
        int[] preIndex2 = new int[256];
        for (int i = 0; i < len1; i++) {
            if (preIndex1[s.charAt(i)] != preIndex2[t.charAt(i)]){
                return false;
            }
            preIndex1[s.charAt(i)] ++;
            preIndex2[t.charAt(i)] ++;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isIsomorphic("add","egg"));
    }
}
