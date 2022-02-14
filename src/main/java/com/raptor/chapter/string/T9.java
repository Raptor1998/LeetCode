package com.raptor.chapter.string;

/**
 * @author raptor
 * @description T9
 * @date 2022/2/14 9:55
 */
public class T9 {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x % 10 == 0 && x != 0) {
            return false;
        }
        int tx = 0;
        while (tx < x) {
            tx = tx * 10 + (x % 10);
            x = x / 10;
        }
        return tx == x || tx / 10 == x;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }
}
