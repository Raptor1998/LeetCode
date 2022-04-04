package com.raptor.chapter.graph;

import org.w3c.dom.ls.LSInput;

import java.beans.Visibility;
import java.util.*;

/**
 * @author raptor
 * @description T1584
 * @date 2022/4/4 20:21
 */
public class T1584 {
    static int[][] g;

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n == 1 || n == 0) {
            return 0;
        }
        // 邻接矩阵存储图
        g = new int[n][n];
        int min_in_st = 0;
        int min_in_end = 0;
        int min_weight = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int w = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                g[i][j] = g[j][i] = w;
                if (w < min_weight) {
                    min_weight = w;
                    min_in_st = i;
                    min_in_end = j;
                }
            }
        }
        int ret = 0;
        boolean[] vis = new boolean[n];
        vis[min_in_end] = true;
        vis[min_in_st] = true;
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(min_weight);
        int flag = 2;
        while (flag < n) {
            int min_value = Integer.MAX_VALUE;
            int min_point = -1;
            for (int j = 0; j < n; j++) {
                if (vis[j] == false) {
                    Integer next = j;
                    for (int i = 0; i < n; i++) {
                        int dis = g[i][next];
                        if (vis[i] && !vis[next] && dis < min_value) {
                            min_value = dis;
                            min_point = next;
                        }
                    }
                }
            }
            if (min_point != -1) {
                flag++;
                vis[min_point] = true;
                objects.add(min_value);
            }
        }
        for (Integer object : objects) {
            ret += object;
        }
        return ret;
    }


    public static void main(String[] args) {
        int[][] points = {
                {0,0},{2,2},{3,10},{5,2},{7,0}
        };
        System.out.println(new T1584().minCostConnectPoints(points));
    }
}
