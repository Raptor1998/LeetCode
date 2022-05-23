package com.raptor.random;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raptor
 * @description Planet
 * @date 2022/4/21 15:02
 */
public class Planet {
    public List<Integer> exchange(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            //如果还存在
            if (!vis[i] && nums[i] < 0) {
                for (int j = i - 1; j >= 0; j--) {
                    // i 位置保留  继续向左撞击
                    if (nums[j] > 0 && Math.abs(nums[i]) > nums[j]) {
                        vis[j] = true;
                    } else if (nums[j] > 0 && Math.abs(nums[i]) < nums[j]) {
                        //i  破碎
                        vis[i] = true;
                        break;
                    } else if (nums[j] > 0 && Math.abs(nums[i]) == nums[j]){
                        vis[i] = vis[j] = true;
                        break;
                    }
                }
            } else if (!vis[i] && nums[i] > 0) {
                for (int j = i + 1; j < n; j++) {
                    //i  保留
                    if (nums[j] < 0 && nums[i] > Math.abs(nums[j])) {
                        vis[j] = true;
                    } else if (nums[j] < 0 && nums[j] < Math.abs(nums[j])) {
                        vis[i] = true;
                        break;
                    } else if (nums[j] < 0 && nums[j] == Math.abs(nums[j])){
                        vis[i] = vis[j] = true;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-3, 4, 5, 2, -3, 2, 5, -7, 3, -9, 3, -12, 9};
        List<Integer> exchange = new Planet().exchange(a);
        for (Integer integer : exchange) {
            System.out.println(integer);
        }
    }
}
