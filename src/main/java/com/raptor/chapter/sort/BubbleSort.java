package com.raptor.chapter.sort;

import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import java.util.GregorianCalendar;

/**
 * @author raptor
 * @description BubbleSort
 * @date 2022/2/12 17:00
 */
public class BubbleSort {
    static int num = 0;

    public static void bubbleSort(int R[]) {
        int n = R.length;
        for (int i = n - 1; i >= 0; i--) {
            int flag = 1;
            for (int j = 0; j < i; j++) {
                if (R[j] > R[j + 1]) {
                    swap(R, j, j + 1);
                    flag = 0;
                }
            }
            if (flag == 1) {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {6, 7, 5, 3, 4, 4, 9, 8, 0};
        bubbleSort(nums);
        System.out.println(num);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
