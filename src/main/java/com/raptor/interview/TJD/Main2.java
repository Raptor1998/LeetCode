package com.raptor.interview.TJD;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String s = scanner.next();
            int[] num = new int[3];
            for (int j = 0; j < 3 * n; j++) {
                char c = s.charAt(j);
                num[c - 'A']++;
            }
            if (num[0] == num[1] && num[1] == num[2]) {
                System.out.println(0);
            }else {
                System.out.println(2);
            }
        }
    }
}
