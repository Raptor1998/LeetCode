package com.raptor.random;

import java.time.chrono.MinguoChronology;

/**
 * @author raptor
 * @description MixedAll
 * @date 2022/2/23 19:56
 */
public class MixedAll {
    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3};
        mix(a, 0, a.length - 1);
    }

    public static void mix(int[] a, int l, int n) {
        if (l == n) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }

        for (int i = l; i <= n; i++) {
            swap(a, i, l);
            mix(a, l + 1, n);
            swap(a, i, l);
        }
    }

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
