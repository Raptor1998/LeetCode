package com.raptor.chapter.bytedance;

import java.util.Deque;
import java.util.LinkedList;

public class Trap {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        //每列能存储多少水
        for (int i = 1; i < n - 1; i++) {
            int left = 0;
            for (int j = i - 1; j >= 0; j--) {
                left = Math.max(left, height[j]);
            }
            int right = 0;
            for (int j = i + 1; j < n; j++) {
                right = Math.max(right, height[j]);
            }
            if (left > height[i] && right > height[i]) {
                ans += (Math.min(right, left) - height[i]);
            }
        }
        return ans;
    }

    public int trap2(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Trap().trap2(nums));
    }
}



