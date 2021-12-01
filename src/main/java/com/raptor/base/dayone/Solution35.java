package com.raptor.base.dayone;

/**
 * @author raptor
 * @description Solution35
 * @date 2021/12/1 21:30
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class Solution35 {
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int i = searchInsert(nums, 7);
        System.out.println(i);

    }

}
