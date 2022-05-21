package com.raptor.chapter.greedy;

import java.util.ArrayList;
import java.util.List;

public class T39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(ans, list, 0, target, candidates);
        return ans;
    }

    public static void dfs(List<List<Integer>> ans, List<Integer> list, int index, int target, int[] candidates) {
        if (index >= candidates.length) {
            return;
        }
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        if (target == sum) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
            ans.add(new ArrayList<>(list));
            return;
        }
        dfs(ans, list, index + 1, target, candidates);
        if (sum + candidates[index] <= target) {
            list.add(candidates[index]);
            dfs(ans, list, index, target, candidates);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        List<List<Integer>> lists = combinationSum(nums, 7);
    }
}
