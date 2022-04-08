package com.raptor.interview.Ttencentmusic;

public class Main3 {
    public int minCnt(String s) {
        // write code here
        int n = s.length();
        int j = 0;
        while (j < n && s.charAt(j) == '0') {
            j++;
        }
        int num1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                num1++;
            }
        }
        if (num1 == n) {
            return n - 1 + j;
        }
        return n - num1 - 1 + j;

    }

    public static void main(String[] args) {
        System.out.println(new Main3().minCnt("111"));
    }
}
