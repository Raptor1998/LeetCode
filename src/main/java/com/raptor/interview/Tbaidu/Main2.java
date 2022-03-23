package com.raptor.interview.Tbaidu;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int[] preSum = new int[n];
        int window = n - 1;
        preSum[0] = Integer.parseInt(String.valueOf(s.charAt(0)));
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        for (int i = 0; i < n; i++) {
            System.out.print(preSum[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n - window+1; i++) {
            char c1 = s.charAt(i);
            int i1 = preSum[i + window - 1] - preSum[i];
            if (c1 == '1') {
                i1++;
            }
            for (int j = i + 1; j < n - window + 1; j++) {
                System.out.println("当前window：" + window + "  i:" + i + "  j:" + j);
                char c2 = s.charAt(j);
                int i2 = preSum[j + window - 1] - preSum[j];
                if (c2 == '1') {
                    i2++;
                }
                if (i1 == i2 && i != j) {
                    System.out.println((i + 1) + " " + (i + window) + " " + (j + 1) + " " + (j + window));
                    return;
                }
            }
            window--;
        }


    }
}
