package com.enternal.sort;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/23  11:03
 */
public class QuickSort {

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int p = partition(array, left, right);
            quickSort(array, left, p - 1);
            quickSort(array, p + 1, right);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int left = low;
        int right = high;
        if (left < right) {
            int temp = array[left];
            while (left != right) {
                while (left < right && array[right] >= temp) {
                    right--;
                }
                array[left] = array[right];
                while (left < right && array[left] < temp) {
                    left++;
                }
                array[right] = array[left];
            }
            array[left] = temp;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 6, 1, 134, 5, 7};
        quickSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
