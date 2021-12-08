package com.raptor.base.day2;

/**
 * @author raptor
 * @description Solution977
 * @date 2021/12/1 21:40
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class Solution977 {
    public static int[] sortedSquares(int[] nums) {
        int l = nums.length - 1;
        int[] res = new int[l + 1];
        int i = 0, j = l;
        while (l >= 0 && i <= j) {
            if (Math.abs(nums[i]) < Math.abs(nums[j])) {
                res[l] = nums[j] * nums[j];
                j--;
                l--;
            } else if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[l] = nums[i] * nums[i];
                i++;
                l--;
            } else {
                res[l] = nums[i] * nums[i];
                i++;
                l--;
                if (i < j) {
                    res[l] = nums[j] * nums[j];
                    j--;
                    l--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-7, -3, 2, 2, 2};
        int[] res = sortedSquares(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
