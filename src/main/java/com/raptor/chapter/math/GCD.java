package com.raptor.chapter.math;

/**
 * @author raptor
 * @description GCD
 * @date 2022/2/17 11:16
 */
public class GCD {
    public static int gcd(int a, int b) {
        if (b != 0) {
            return gcd(b, a % b);
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(15, 18));
    }
}
