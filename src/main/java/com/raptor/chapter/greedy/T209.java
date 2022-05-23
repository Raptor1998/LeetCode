package com.raptor.chapter.greedy;

import javafx.scene.chart.NumberAxis;

import javax.swing.*;

/**
 * @author raptor
 * @description T209
 * @date 2022/5/23 11:12
 */
public class T209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre[i] >= target) {
                max = Math.min(i + 1, max);
            }
            for (int j = i - 1; j >= 0; j--) {
                if (pre[i] - pre[j] >= target) {
                    max = Math.min(i - j, max);
                }
            }
        }
        return max == Integer.MAX_VALUE ? 0 : max;
    }

    // 滑动窗口
    public static int minSubArrayLen2(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                10,2,3
        };
        System.out.println(minSubArrayLen(6, nums));
    }
}
