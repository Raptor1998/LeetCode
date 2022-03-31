package com.raptor.interview.Tbianlifeng;

import sun.reflect.annotation.AnnotationSupport;

import java.util.*;

/*
4 2
2 3
3 9
6 7
8 2
 */
//
//class Solution {
//    /* Write Code Here */
//
//    static int nowNum = 0;
//    static int nowCost = 0;
//    static int n;
//    static List<Integer> list = new ArrayList<>();
//
//    public int TotalCost(int[][] cost) {
//        int ans = Integer.MAX_VALUE;
//        n = cost.length;
//        boolean vis[] = new boolean[n];
//        dfs(cost, vis);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print("花费："+list.get(i)+" ");
//            ans = Math.min(ans, list.get(i));
//        }
//        System.out.println();
//        return ans;
//    }
//
//    public void dfs(int[][] cost, boolean[] vis) {
//        if (nowNum == n / 2) {
//            for (int i = 0; i < n; i++) {
//                if (vis[i] == false) {
//                    nowCost += cost[i][1];
//                }
//            }
//            list.add(nowCost);
//            for (int i = 0; i < n; i++) {
//                if (vis[i] == false) {
//                    nowCost -= cost[i][1];
//                }
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            if (vis[i] == false) {
//                nowNum++;
//                vis[i] = true;
//                nowCost += cost[i][0];
//                dfs(cost, vis);
//                vis[i] = false;
//                nowNum--;
//                nowCost -= cost[i][0];
//            }
//        }
//    }
//}

public class Main1 {
    static int cost_rows;
    static int res = Integer.MAX_VALUE;
    static int[][] cost;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        cost_rows = 0;
        int cost_cols = 0;
        cost_rows = in.nextInt();
        cost_cols = in.nextInt();

        cost = new int[cost_rows][cost_cols];
        for (int cost_i = 0; cost_i < cost_rows; cost_i++) {
            for (int cost_j = 0; cost_j < cost_cols; cost_j++) {
                cost[cost_i][cost_j] = in.nextInt();
            }
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }
        dfs(0, 0, 0, 0, 0);
        System.out.println(String.valueOf(res));

    }

    public static void dfs(int index, int s_a, int num_a, int s_b, int num_b) {
        if (index == cost_rows) {
            res = Math.min(res, s_a + s_b);
            return;
        }
        if (s_a + s_b >= res) {
            return;
        }
        if (num_a < cost_rows / 2) {
            dfs(index + 1, s_a + cost[index][0], num_a + 1, s_b, num_b);
        }
        if (num_b < cost_rows / 2) {
            dfs(index + 1, s_a, num_a, s_b + cost[index][1], num_b + 1);
        }
    }

}
