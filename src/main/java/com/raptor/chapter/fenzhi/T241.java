package com.raptor.chapter.fenzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author raptor
 * @description T241
 * @date 2022/2/20 17:19
 */
public class T241 {

    public static void printArray(int[] arr, int n) {
        // 打印数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        // 交换函数
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3,4};
        perum(nums, 0, nums.length - 1);
    }

    private static void perum(int[] nums, int p, int q) {
        if (p == q) {
            printArray(nums, q + 1);
        }
        for (int i = p; i <= q; i++) {
            swap(nums, i, p);
            perum(nums, p + 1, q);
            swap(nums, i, p);
        }
    }
}
