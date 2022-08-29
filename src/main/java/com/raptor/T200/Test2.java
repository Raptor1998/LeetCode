package com.raptor.T200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/27  20:35
 */
public class Test2 {
    static boolean[] vis;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public static void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
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

    public static final int mod = 1000000007;

    public static long ppow(int a, int b) {
        long res = 1;
        long base = a;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = res * base % mod;
            }
            base = base * base % mod;
            b >>= 1;
        }
        return res % mod;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ppow(26,590));
    }
}


/*
6   1
7   3
8   6
9   10
10   15
11   21
12   28
13   36
14   45
15   55
16   66
17   78
18   91
19   105
 */