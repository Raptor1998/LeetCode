package com.raptor.chapter.greedy;

public class T42 {
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        int i = 0;
        int j = 1;
        while (j < n) {
            if (height[i] <= height[j]) {
                for (int k = i; k < j; k++) {

                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new T42().trap(height));
    }
}
