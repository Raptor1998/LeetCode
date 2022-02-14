package com.raptor.chapter.sort;

/**
 * @author raptor
 * @description BubbleSort
 * @date 2022/2/12 17:00
 */
public class BubbleSort {
    static int num = 0;

    public static void bubbleSort(int R[]) {

        for (int i = 0; i < R.length; i++) {
            int flag = 1;
            for (int j = 0; j < R.length - i; j++) {
                num++;
                if (R[j] > R[i]) {
                    swap(R, i, j);
                    flag = 0;
                }
            }
            if (flag == 1) {
                return;
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {6, 7, 5, 3, 4, 4, 9, 8, 50, 54, 45, 48, 4, 15, 45, 41};
        bubbleSort(nums);
        System.out.println(num);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
