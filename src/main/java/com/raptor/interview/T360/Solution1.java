package com.raptor.interview.T360;

import java.util.Scanner;

/**
 * @author raptor
 * @description Solution1
 * @date 2022/3/19 15:51
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] target = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                target[i] = scanner.nextInt();
                //只打中一个
                sum += target[i];
                if (i > 0) {
                    for (int j = i - 1; j >= 0; j--) {
                        sum += (target[i] | target[j]);
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
