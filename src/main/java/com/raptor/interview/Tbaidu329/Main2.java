package com.raptor.interview.Tbaidu329;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ans = 0;
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            ans = 0;
            for (int j = 1; j < Math.sqrt(n); j++) {
                if (n % j == 0) {
                    int lcm = lcm(j, n / j);
                    if (lcm == n) {
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }

    }


    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        int gcd = gcd(a, b);
        return a * b / gcd;
    }

}

