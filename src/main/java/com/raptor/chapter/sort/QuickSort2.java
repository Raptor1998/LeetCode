package com.raptor.chapter.sort;

import com.raptor.interview.Tbaidu329.Test;
import org.springframework.core.env.Profiles;

/**
 * @author raptor
 * @description QuickSort2
 * @date 2022/4/3 17:26
 */
public class QuickSort2 {

    public static void sort(int[] nums, int low, int high) {
        if (low < high) {
            int partition = partition(nums, low, high);
            sort(nums, low, partition - 1);
            sort(nums, partition + 1, high);
        }
    }

    public static int partition(int[] nums, int low, int high) {
        int left = low;
        int right = high;
        if (left < right) {
            int temp = nums[left];
            while (left != right) {
                while (left < right && nums[right] >= temp) {
                    right--;
                }
                nums[left] = nums[right];
                while (left < right && nums[left] < temp) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = temp;

        }
        return left;
    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void sort2(int[] nums, int low, int high) {
        int left = low;
        int right = high;
        if (left < right) {
            int temp = nums[left];
            while (left != right) {
                while (left < right && nums[right] >= temp) {
                    right--;
                }
                nums[left] = nums[right];
                while (left < right && nums[left] < temp) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = temp;
            sort2(nums, low, left - 1);
            sort2(nums, left + 1, high);
        }
    }


    public static void main(String[] args) {
        int[] nums = {6, 7, 5, 3, 4, 4, 9, 8, 0};
        sort2(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
