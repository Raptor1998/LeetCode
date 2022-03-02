package com.raptor.chapter.sort;

/**
 * @author raptor
 * @description MergeSort
 * @date 2022/3/1 18:40
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 7, 2, 6, 4};
        printArray(a);
        merger_sort(a);
        printArray(a);
    }

    public static void merger_sort(int R[]) {
        int length = R.length;
        int[] tempArr = new int[length];
        msort(R, tempArr, 0, length - 1);
    }

    private static void msort(int[] R, int[] tempArr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            msort(R, tempArr, left, mid);
            msort(R, tempArr, mid + 1, right);
            merge(R, tempArr, left, mid, right);
        }
    }

    private static void merge(int[] R, int[] tempArr, int left, int mid, int right) {
        int l_pos = left;
        int r_pos = mid + 1;
        int cur_pos = left;
        while (cur_pos <= mid && r_pos <= right) {
            if (R[l_pos] < R[r_pos]) {
                tempArr[cur_pos++] = R[l_pos++];
            } else {
                tempArr[cur_pos++] = R[r_pos++];
            }

        }
        while (l_pos <= mid) {
            tempArr[cur_pos++] = R[l_pos++];
        }
        while (r_pos <= right) {
            tempArr[cur_pos++] = R[r_pos++];
        }
        while (left <= right) {
            R[left] = tempArr[left];
            left++;
        }
    }

    public static void printArray(int a[]) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
