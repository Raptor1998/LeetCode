package com.raptor.chapter.mayi;

import java.math.BigInteger;

/**
 * @author raptor
 * @description NZero
 * @date 2022/3/1 21:29
 */
public class NZero {
    public static long trailingZeros(long n) {
        // write your code here
        // 1 2 3 4 5 *  25 / 5 = > 5 / 5
        long res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeros(50L));
    }
}
