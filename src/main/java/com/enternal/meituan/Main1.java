package com.enternal.meituan;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            String s1 = scanner.next();
            String s2 = scanner.next();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                stringBuilder.append(c1);
                stringBuilder.append(c2);
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
