package com.raptor.base.day3;

/**
 * @author raptor
 * @description Solution283
 * @date 2021/12/4 21:07
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class Solution283 {
    public static void moveZeroes1(int[] nums) {
        int n = nums.length;
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero++;
            } else {
                nums[i - zero] = nums[i];
            }
        }
        for (int j = zero; j > 0; j--) {
            nums[n - j] = 0;
        }

    }

    //双指针法
    public static void moveZeroes(int[] nums) {
        int low = 0;
        int high = 0;
        while (high < nums.length) {
            if (nums[high] != 0) {
                //    右指针不为0，则与左边交换
                int temp = nums[high];
                nums[high] = nums[low];
                nums[low] = temp;
                low++;
            }
            high++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
