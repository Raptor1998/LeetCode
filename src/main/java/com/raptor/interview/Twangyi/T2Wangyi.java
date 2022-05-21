package com.raptor.interview.Twangyi;

import org.junit.internal.runners.SuiteMethod;

import java.util.Scanner;

public class T2Wangyi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int x = scanner.nextInt();
        int nums[] = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            sum += nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {

            int low = sum - nums[i] + 1;
            int high = sum - nums[i] + p;
            int left = low / x;
            int right = high / x;
            if (low % x == 0){
                ans++;
            }
            if (p < nums[i]) {
                ans += (right - left);
            }
            System.out.println("low:" + low + "  high:" + high);
            System.out.println(i + " " + ans);
        }
        System.out.println(ans);
    }
}
/*
4 3 2
2 5 3 4
 */