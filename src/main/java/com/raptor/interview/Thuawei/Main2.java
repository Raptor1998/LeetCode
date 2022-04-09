package com.raptor.interview.Thuawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            int pre = scanner.nextInt();
            for (int j = 0; j < pre; j++) {
                int x = scanner.nextInt();
                //服务i到x    x依赖于i
                map[x][i] = 1;
            }
        }
        ArrayList<Integer> pre = getPre(map, n, m);
        for (Integer integer : pre) {
            System.out.print(integer + " ");
        }
    }

    public static ArrayList<Integer> getPre(int[][] map, int n, int st) {
        boolean[] vis = new boolean[n];

        boolean circle = isCircle(map, st, vis, st);
        if (circle == false) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(-1);
            return ans;
        } else {
            boolean[] vis2 = new boolean[n];
            dfs(map, st, vis2);
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (vis2[i]) {
                    list.add(i);
                }
            }
            Collections.sort(list);
            return list;
        }
    }

    //获取前置节点
    public static void dfs(int[][] map, int t, boolean[] vis) {
        for (int i = 0; i < map.length; i++) {
            if (map[i][t] == 1) {
                if (!vis[i]) {
                    vis[i] = true;
                    dfs(map, i, vis);
                }
            }
        }
    }

    public static boolean isCircle(int[][] map, int t, boolean[] vis, int st) {
        for (int i = 0; i < map.length; i++) {
            //起始点出发
            if (map[t][i] == 1) {
                if (i == st) {
                    return false;
                }
                if (!vis[i]) {
                    vis[i] = true;
                    return isCircle(map, i, vis, st);
                }
            }
        }
        return true;
    }

}
/*
4
2
0
1 0
1 1
2 0 1
* */