package com.raptor.interview.Twangyi;

import java.util.Scanner;
import java.util.Stack;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] ans = new int[n];
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    stack1.add(i);
                } else {
                    stack2.add(i);
                }
            }
            int index = 0;
            for (int i = 1; i <= n; i++) {
                if (2 * i > n) {
                    ans[index++] = stack2.pop();
                } else {
                    ans[index++] = stack1.pop();
                }
            }
            for (int i = 0; i < index - 1; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println(ans[index - 1]);
        }
    }
}
