package com.raptor.interview.Twangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(getVal(new long[]{25,8,10},1,0));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long value[] = new long[n];
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            value[i] = scanner.nextLong();
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int st = scanner.nextInt();
            int end = scanner.nextInt();
            int val = getVal(value, st - 1, end - 1);
            map[st - 1][end - 1] = val;
            map[end - 1][st - 1] = val;
            sum += val;
        }
        int ret = minCostConnectPoints(map);
        System.out.println(sum - ret);
    }

    public static int getVal(long[] value, int i, int j) {
        long tempi = value[i];
        long tempj = value[j];
        int cnt = 0;
        while (tempi > 0 && tempi % 10 == 0) {
            cnt++;
            tempi /= 10;
        }
        while (tempj > 0 && tempj % 10 == 0) {
            cnt++;
            tempj /= 10;
        }
        long temp = tempi * tempj;
        while (temp > 0 && temp % 10 == 0) {
            cnt++;
            temp /= 10;
        }
        return cnt;
    }

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];
        boolean[] st = new boolean[n];
        Arrays.fill(dist, 0x3f3f3f);
        int ret = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 0; j < n; j++) {
                // 找到未在最小生成树中  离最小生成树的点
                if (!st[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }
            if (i != 0) {
                ret += dist[t];
            }
            list.add(t);
            st[t] = true;
            for (int j = 0; j < n; j++) {
                if (dist[j] > points[t][j]) {
                    dist[j] = points[t][j];
                }
            }

        }
        return ret;
    }
}

/*
3 3
5 8 25
1 2
2 3
1 3
 */
