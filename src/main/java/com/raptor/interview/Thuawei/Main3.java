package com.raptor.interview.Thuawei;

import java.util.Scanner;
import java.util.Stack;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String s = scanner.next();
        String[] split = s.split(",");
        int[] heights = new int[m];
        int minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            heights[i] = Integer.parseInt(split[i]);
            minHeight = Math.min(minHeight, heights[i]);
        }
        int[][] dp = new int[Math.abs(minHeight) + 1][m];
        int ans = 0;
        for (int i = 0; i > minHeight; i--) {
            int absi = Math.abs(i);
            if (heights[0] < i) {
                dp[absi][0] = 1;
            }
            for (int j = 1; j < m; j++) {
                if (heights[j] < i) {
                    dp[absi][j] = dp[absi][j - 1] + 1;
                } else {
                    dp[absi][j] = 0;
                }
            }
        }
        for (int i = 0; i > minHeight; i--) {
            int absi = Math.abs(i);
            for (int j = 0; j < m - 1; j++) {
                if (dp[absi][j + 1] == 0) {
                    ans += dp[absi][j] / n;
                }
            }
        }

        System.out.println(ans);

    }
/*
2
4
0,-1,-2,0
 */

//        System.out.println(getAns(heights,n));


    public static int getAns(int[] height, int n) {
        int ans = 0;
        int length = height.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int tmp = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]);
                if (currWidth < n || currHeight > 0) {
                    continue;
                }
                ans += currWidth / n;
            }
            stack.push(i);
        }

        return ans;
    }
}
