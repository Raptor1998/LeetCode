package com.raptor.interview.Thuawei;

import javax.xml.stream.events.EndDocument;
import java.util.Scanner;
import java.util.Stack;

public class Main2 {
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
        System.out.println(getAns(heights,n));
    }

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
