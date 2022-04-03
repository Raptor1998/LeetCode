package com.raptor.interview.TJD;

import sun.nio.cs.ext.Big5_HKSCS;

import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long st = scanner.nextLong();
        String step = scanner.next();
        int pow = 0;
        int temp = 1;
        while (temp <= st) {
            temp *= 2;
            pow++;
        }
        pow--;
        st = st - temp / 2;
        System.out.println("pow:" + pow);
        System.out.println("st:" + st);
        BigInteger mod = new BigInteger(String.valueOf(st));
        for (int i = 0; i < n; i++) {
            char c = step.charAt(i);
            if (c == 'U') {
                pow--;
                mod = mod.divide(BigInteger.valueOf(2));
            } else if (c == 'L') {
                pow++;
                mod = mod.multiply(BigInteger.valueOf(2));
            } else {
                pow++;
                mod = mod.multiply(BigInteger.valueOf(2));
                mod = mod.add(BigInteger.valueOf(1));
            }
        }
        BigInteger bigInteger = new BigInteger(String.valueOf(2));
        BigInteger pow1 = bigInteger.pow(pow);
        System.out.println(pow1.add(mod));
//        BigInteger ans = new BigInteger(String.valueOf(st));
//        for (int i = 0; i < n; i++) {
//            char c = step.charAt(i);
//            if (i<n-1){
//                char c2 = step.charAt(i + 1);
//                if ((c == 'U' && c2 == 'L') || (c == 'L' && c2 == 'U')) {
//                    continue;
//                }
//            }
//            if (c == 'U') {
//                ans = ans.divide(BigInteger.valueOf(2));
//            } else if (c == 'L') {
//                ans = ans.multiply(BigInteger.valueOf(2));
//            } else {
//                ans = ans.multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(1));
//            }
//        }
//        System.out.println(ans);
    }
}
