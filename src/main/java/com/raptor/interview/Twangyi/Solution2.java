package com.raptor.interview.Twangyi;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 2;
        long nums[] = new long[]{10, 2};
        myStruct dp[][] = new myStruct[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = new myStruct(nums[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    ans += dp[i][i].numZero;
                } else {
                    myStruct struct1 = dp[i][j - 1];
                    myStruct struct2 = new myStruct(nums[j]);
                    long pre = struct1.pre * struct2.pre;
                    int numZero = struct1.numZero + struct2.numZero;
                    while (pre > 0 && pre % 10 == 0) {
                        numZero++;
                        pre /= 10;
                    }
                    dp[i][j] = new myStruct(pre, numZero);
                    ans += dp[i][j].numZero;
                }
            }
        }
        System.out.println(ans);
    }

    static class myStruct {
        long pre;
        int numZero;

        public myStruct(long num) {
            long temp = num;
            int cnt = 0;
            while (temp > 0 && temp % 10 == 0) {
                cnt++;
                temp /= 10;
            }
            this.pre = temp;
            this.numZero = cnt;
        }

        public myStruct(long pre, int numZero) {
            this.pre = pre;
            this.numZero = numZero;
        }

        @Override
        public String toString() {
            return "struct{" +
                    "pre=" + pre +
                    ", numZero=" + numZero +
                    '}';
        }
    }
}
