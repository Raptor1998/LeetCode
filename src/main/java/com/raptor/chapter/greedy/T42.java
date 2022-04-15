package com.raptor.chapter.greedy;

import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class T42 {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }


    public int trap2(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public int trap3(int[] height) {
        int sum = 0;
        int n = height.length;
        int[] max_left = new int[n];
        int[] max_right = new int[n];
        for (int i = 1; i < n; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(max_left[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(max_right[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    public int trap4(int[] height) {
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            //栈不为空  并且  栈顶元素小于当前高度
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer pop = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                Integer left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[pop];
                sum += currWidth * currHeight;
            }
            stack.push(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new T42().trap4(height));
    }
}
