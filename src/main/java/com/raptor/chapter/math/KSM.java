package com.raptor.chapter.math;

/**
 * @author raptor
 * @description KSM
 * @date 2022/2/24 11:17
 */
public class KSM {
    public static int ppow(int a, int b, int mod) {
        int ans = 1;
        int base = a;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * base % mod;
            }
            base *= base;
            b >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(ppow(3, 4, 1000007));
    }
}
