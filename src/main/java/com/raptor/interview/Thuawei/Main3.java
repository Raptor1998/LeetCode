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
        int[] heights = new int[m + 1];
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

        System.out.println(getAns2(heights, n));

    }
/*
2
4
0,-1,-2,0
 */

//        System.out.println(getAns(heights,n));


    public static int getAns(int[] height, int n) {
        int ans = 0;
        int m = height.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < m; i++) {
            while (stack.peek() != -1 && height[stack.peek()] < height[i]) {
                Integer pop = stack.pop();
                int h = height[pop];
                int pre = stack.peek();
                h -= Math.min(pre == -1 ? 0 : height[pre], height[i]);
                if (i - pre - 1 >= n && h < 0) {
                    int t = (i - pre - 1) / n;
                    ans += (t * (-h));
                }
            }
            stack.push(i);
        }
        return ans;
    }

    public static int getAns2(int[] height, int n) {
        int length = height.length;
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            //栈不为空  并且  栈顶元素小于当前高度
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer pop = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                Integer left = stack.peek();
                int currWidth = i - left - 1;
                //当前的高度和左端的地点处才能存储货物     此时的Height[pop] 一定小于当前的高度
                int currHeight = Math.min(height[left], height[i]) - height[pop];
                if (currWidth < n || currHeight < 0) {
                    continue;
                }
                int i1 = currWidth / n;
                sum += (i1 * currHeight);

            }
            stack.push(i);
        }
        return sum;
    }
}