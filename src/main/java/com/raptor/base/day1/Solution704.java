package com.raptor.base.day1;

/**
 * @author raptor
 * @description Solution704
 * @date 2021/11/29 21:21
 * https://leetcode-cn.com/problems/binary-search/
 */
public class Solution704 {
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle;
        while (low <= high) {
            middle = (high - low) / 2 + low;
            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                low = middle + 1;
            } else if (target < nums[middle]) {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = search(nums, -1);
        System.out.println(target);
    }
}
