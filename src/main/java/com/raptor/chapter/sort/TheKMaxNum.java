package com.raptor.chapter.sort;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author raptor
 * @description TheKMaxNum
 * @date 2022/3/1 14:05
 */
public class TheKMaxNum {
    public static void main(String[] args) {
        int a[] = new int[]{5, 1, 1, 2, 0, 0};
        int k = 2;
        quickSort2(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        System.out.println(findKthLargest(a,k));
    }

    public static void quickSort2(int R[], int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(R, lo, hi);
            quickSort2(R, lo, pivot - 1);
            quickSort2(R, pivot + 1, hi);
        }
    }

    private static int partition(int[] R, int lo, int hi) {
        int left = lo;
        int right = hi;
        if (left < right) {
            int temp = R[left];
            while (left != right) {
                while (left < right && temp <= R[right]) {
                    right--;
                }
                R[left] = R[right];
                while (left < right && temp >= R[left]) {
                    left++;
                }
                R[right] = R[left];
            }
            R[left] = temp;
        }
        return left;
    }

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的下标是 len - k
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }
    public static void swap(int[] R, int i, int j) {
        int temp = R[i];
        R[i] = R[j];
        R[j] = temp;
    }
}
