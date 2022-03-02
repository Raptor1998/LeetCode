package com.raptor.chapter.mayi;

/**
 * @author raptor
 * @description JumpGame
 * @date 2022/3/2 9:18
 */
public class JumpGame {
    public static void main(String[] args) {
        int a[] = {2, 3, 1, 1, 4};
        System.out.println(canJump(a));
    }

    public static boolean canJump(int[] a) {
        // write your code here
        int n = a.length;
        int longest = 0;
        for (int i = 0; i < n; i++) {
            if (i<=longest){
                longest = Math.max(longest,i+a[i]);
            }
            if (longest>=n-1){
                return true;
            }
        }
        return false;
    }
}
