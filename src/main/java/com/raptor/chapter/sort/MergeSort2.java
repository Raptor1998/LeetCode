package com.raptor.chapter.sort;

/**
 * @author raptor
 * @description MergeSort2
 * @date 2022/4/4 15:40
 */
public class MergeSort2 {
    /*
     * 将一个数组中的两个相邻有序区间合并成一个
     *
     * 参数说明:
     *     a -- 包含两个有序区间的数组
     *     start -- 第1个有序区间的起始地址。
     *     mid   -- 第1个有序区间的结束地址。也是第2个有序区间的起始地址。
     *     end   -- 第2个有序区间的结束地址。
     */
    public static void merge(int[] a, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];    // tmp是汇总2个有序区的临时区域
        int i = start;            // 第1个有序区的索引
        int j = mid + 1;        // 第2个有序区的索引
        int k = 0;                // 临时区域的索引
        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= end) {
            tmp[k++] = a[j++];
        }
        // 将排序后的元素，全部都整合到数组a中。
        for (i = 0; i < k; i++) {
            a[start + i] = tmp[i];
        }
    }

    public static void mergeSortUp2Down(int[] a, int start, int end) {
        if (a == null || start >= end) {
            return;
        }

        int mid = (end + start) / 2;
        mergeSortUp2Down(a, start, mid); // 递归排序a[start...mid]
        mergeSortUp2Down(a, mid + 1, end); // 递归排序a[mid+1...end]

        // a[start...mid] 和 a[mid...end]是两个有序空间，
        // 将它们排序成一个有序空间a[start...end]
        merge(a, start, mid, end);
    }

    public static void main(String[] args) {
        int i;
        int a[] = {80, 30, 60, 40, 20, 10, 50, 70};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");

        mergeSortUp2Down(a, 0, a.length - 1);        // 归并排序(从上往下)

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");
    }
}
