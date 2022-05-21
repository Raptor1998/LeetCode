package com.raptor.chapter.greedy;


import java.util.ArrayList;
import java.util.List;

public class T46 {
    static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        mix(nums, 0, nums.length - 1);
        return list;
    }
    public static void mix(int[] a, int l, int n) {
        if (l == n) {
            List<Integer> listOne = new ArrayList();
            for (int i = 0; i < a.length; i++) {
                listOne.add(a[i]);
            }
            list.add(listOne);

        }
        for (int i = l; i <= n; i++) {
            if (i != l && a[i] == a[l]){
                continue;
            }
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

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = new T46().permute(nums);
        for (List<Integer> list : permute) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
