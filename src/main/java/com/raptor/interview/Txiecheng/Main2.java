package com.raptor.interview.Txiecheng;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int t = scanner.nextInt();
            for (int i = 0; i < t; i++) {
                long n = scanner.nextInt();
                long m = scanner.nextInt();
                long sum = 0;
                while (m > 0) {
                    long m_last = m % 10;
                    m /= 10;
                    long temp = n * m_last;
                    sum += temp;
                }
                System.out.println(sum);
            }
        }
    }
}
