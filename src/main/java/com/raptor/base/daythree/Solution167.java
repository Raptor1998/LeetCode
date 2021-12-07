package com.raptor.base.daythree;

import com.sun.istack.internal.NotNull;

/**
 * @author raptor
 * @description Solution167
 * @date 2021/12/4 21:26
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class Solution167 {
    public static int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            if (numbers[low] == target - numbers[high]) {
                index[0] = low + 1;
                index[1] = high + 1;
                return index;
            } else if (numbers[low] < target - numbers[high]) {
                low++;
            } else {
                high--;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 4};
        int target = 6;
        int[] twoSum = twoSum(numbers, target);
        for (int i : twoSum) {
            System.out.println(i);
        }
    }
}
