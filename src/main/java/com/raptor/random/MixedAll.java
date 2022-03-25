package com.raptor.random;

import java.time.Period;
import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author raptor
 * @description MixedAll
 * @date 2022/2/23 19:56
 */
public class MixedAll {
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        int a[] = new int[]{1,1,2};
        permute(a);
        for (int i = 0; i < list.size(); i++) {
            for (Integer integer : list.get(i)) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

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


    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && vis[i - 1] == false)) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }


}
