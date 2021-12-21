package com.raptor.offer.day08;

import java.io.PipedReader;
import java.util.Scanner;

public class Offer10 {
    public static final int mod = 1000000007;

    public static int fib1(int n) {
        if (n == 0 || n == 1) {
            return n % mod;
        }
        return fib(n - 1) % mod + fib(n - 2) % mod;
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (a + b) % mod;
            a = b;
            b = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(fib(n));
        }

    }
}

