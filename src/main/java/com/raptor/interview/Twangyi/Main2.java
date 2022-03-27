package com.raptor.interview.Twangyi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            int n = s.length();
            int[] d = new int[n];
            d[0] = 0;
            for (int i = 1; i < n; i++) {
                if (Math.abs(s.charAt(i) - s.charAt(i - 1)) > 1) {
                    d[i] = d[i - 1];
                } else {
                    int i1 = i >= 2 ? d[i - 2] : 0;
                    d[i] = Math.max(d[i - 1], s.charAt(i)  + s.charAt(i - 1) + i1 - 192);
                }
            }
            System.out.println(d[n-1]);
        }
    }
}
