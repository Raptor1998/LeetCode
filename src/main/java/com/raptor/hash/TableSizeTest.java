package com.raptor.hash;

/**
 * @author raptor
 * @description TableSizeTest
 * @date 2022/2/15 20:25
 */
public class TableSizeTest {
    private static final int MAXIMUM_CAPACITY = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println("----");

        System.out.println(tableSizeFor(500));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
