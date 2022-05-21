package com.raptor.interview.Thuawei;

import sun.security.krb5.Asn1Exception;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class T511Main1 {
    static int n;
    static int[] ans = new int[n];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[] nextSmall = getNextSmall(n, nums);
        ans[n - 1] = 0;
        getAns(n, nums, nextSmall);
        for (int i = 0; i < n - 1; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println(ans[n - 1]);
    }

    public static void getAns(int n, int[] nums, int[] nextSmall) {
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(nextSmall[n - i - 1] + " ");
            if (nextSmall[i] != -1) {
                ans[i] = ans[nextSmall[i]] + 1;
            } else {
                //右边没有比自己小的
                ans[i] = 0;
            }
        }
        System.out.println();
    }

    public static int[] getNextSmall(int n, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                next[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            next[stack.pop()] = -1;
        }
        return next;
    }
}
