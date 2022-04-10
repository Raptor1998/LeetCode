package com.raptor.chapter.bytedance;

import java.awt.image.TileObserver;
import java.util.Queue;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int left = -1;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                left = i - 1;
                break;
            }
        }
        int right = n - 1;
        if (left >= 0) {
            for (int i = n - 1; i > left; i--) {
                if (nums[i] > nums[left]) {
                    right = i;
                    break;
                }
            }
            swap(nums, left, right);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        System.out.println(left + " " + right);
        reverse(nums, left + 1);

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new NextPermutation().nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
