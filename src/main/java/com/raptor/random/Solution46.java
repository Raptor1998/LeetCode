package com.raptor.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author raptor
 * @description Solution46
 * @date 2021/12/9 10:25
 * https://leetcode-cn.com/problems/permutations/
 */
public class Solution46 {
    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }


    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        pre(n, 0);
        return res;
    }

    private static void pre(int n, int first) {

    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }
}
