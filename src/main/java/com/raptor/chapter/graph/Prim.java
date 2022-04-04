package com.raptor.chapter.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author raptor
 * @description Prim
 * @date 2022/4/4 20:29
 */
public class Prim {
    static int N = 1010;

    public int minCostConnectPoints(int[][] points) {
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
        System.out.println("访问节点：");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();

        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] g = new int[n][n];
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            g[x][y] = g[y][x] = z;
        }
        System.out.println("最小消耗：");
        System.out.println(new Prim().minCostConnectPoints(g));
    }
}
