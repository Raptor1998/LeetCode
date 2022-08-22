package com.enternal.dynamic;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/19  23:54
 */
public class MinCost {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] sum = new int[n];
        sum[0] = cost[0];
        sum[1] = cost[1];
        for(int i = 2;i<n;i++){
            sum[i] = Math.min(sum[i-1],sum[i-2]) + cost[i];
        }
        return Math.min(sum[n-1],sum[n-2]);
    }

    public static void main(String[] args) {
        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
