package com.raptor.chapter.greedy;

import sun.reflect.generics.visitor.Reifier;

import java.beans.beancontext.BeanContext;

/**
 * @author raptor
 * @description T34
 * @date 2022/5/16 15:06
 */
public class T34 {
    public int[] searchRange(int[] nums, int target) {
        int range = range(nums, target);
        if (range == -1) {
            return new int[]{-1, -1};
        } else {
            int right = range;
            for (int i = range + 1; i < nums.length; i++) {
                if (nums[i] == target) {
                    right = i;
                }else {
                    break;
                }
            }
            int left = range;
            for (int i = range - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    left = i ;
                }else {
                    break;
                }
            }
            return new int[]{left, right};
        }
    }

    public int range(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 2};
        int[] ints = new T34().searchRange(nums, 2);
        System.out.println(ints[0]);
        System.out.println(ints[1]);

    }
}
