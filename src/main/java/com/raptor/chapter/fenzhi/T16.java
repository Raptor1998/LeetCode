package com.raptor.chapter.fenzhi;

import java.util.Arrays;

/**
 * @author raptor
 * @description T16
 * @date 2022/4/6 16:54
 */
public class T16 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 100000;
        for (int i = 0; i < n; i++) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {
                -3, -2, -5, 3, -4
        };
        System.out.println(new T16().threeSumClosest(nums, -1));
    }
}
