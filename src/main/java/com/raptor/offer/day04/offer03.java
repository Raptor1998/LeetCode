package com.raptor.offer.day04;

import java.util.HashSet;
import java.util.Set;

/**
 * @author raptor
 * @description offer03
 * @date 2021/12/17 10:12
 */
public class offer03 {
    public static int findRepeatNumber1(int[] nums) {
        int[] sum = new int[nums.length];
        int max = -1;
        int maxVal = -1;
        for (int num : nums) {
            sum[num]++;
            if (sum[num] > max) {
                max = sum[num];
                maxVal = num;
            }
        }
        return maxVal;
    }

    public static int findRepeatNumber2(int[] nums) {
        Set<Integer> dic = new HashSet<>();
        for (int num : nums) {
            if (dic.contains(num)) {
                return num;
            }
            dic.add(num);
        }
        return -1;
    }

    public static int findRepeatNumber(int[] nums) {
        int i = 0, n = nums.length;
        while (i < n) {
            //索引nums[i]位置已经换过，
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            swap(nums, i, nums[i]);
        }
        return -1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        System.out.println(findRepeatNumber(nums));
    }
}
