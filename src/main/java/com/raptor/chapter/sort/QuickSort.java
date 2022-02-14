package com.raptor.chapter.sort;

/**
 * @author raptor
 * @description QuickSort
 * @date 2022/2/12 15:10
 */
public class QuickSort {

    public static void quickSort(int R[], int lo, int hi) {
        int i = lo, j = hi;
        int temp;
        if (i < j) {
            temp = R[i];
            while (i != j) {
                while (i < j && temp >= R[j]) {
                    j--;
                }
                R[i] = R[j];
                while (i < j && temp <= R[i]) {
                    i++;
                }
                R[j] = R[i];
            }
            R[i] = temp;
            quickSort(R, lo, i - 1);
            quickSort(R, i + 1, hi);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort2(int R[], int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(R, lo, hi);
            System.out.println(pivot);
            partition(R, lo, pivot - 1);
            partition(R, pivot + 1, hi);
        }
    }

    private static int partition(int[] R, int lo, int hi) {
        int i = lo, j = hi;
        int temp;
        if (i < j) {
            temp = R[i];
            while (i != j) {
                while (i < j && temp <= R[j]) {
                    j--;
                }
                R[i] = R[j];
                while (i < j && temp >= R[i]) {
                    i++;
                }
                R[j] = R[i];
            }
            R[i] = temp;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {6, 7, 5, 3, 4, 4, 9, 8};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
