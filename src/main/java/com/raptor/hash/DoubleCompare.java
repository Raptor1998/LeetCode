package com.raptor.hash;

/**
 * @author raptor
 * @description DoubleCompare
 * @date 2022/2/15 18:49
 */
public class DoubleCompare {
    public static void main(String[] args) {
        float a = 2.0f - 1.9f;
        float b = 1.8f - 1.7f;
        System.out.println(a);// 0.100000024
        System.out.println(b);// 0.099999905
        System.out.println(a == b);// false

        float c = 1.25f;
        float d = 0.23f;
        float e = 1.9f - 1.8f;

        System.out.println(e);
        System.out.println(e == (c - d));

        int hash = 4;
        System.out.println(hash ^ (hash >>> 16));
    }
}
