package com.raptor.chapter.dfs;

import java.util.Map;

public class FindWhetherExistsPath {
    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        boolean[] vis = new boolean[n];
        dfs(graph, start, vis);
        if (vis[target] == true) {
            return true;
        } else {
            return false;
        }
    }

    public static void dfs(int[][] graph, int st, boolean[] vis) {
        for (int i = 0; i < graph.length; i++) {
            if (!vis[graph[i][1]] && graph[i][0] == st) {
                vis[graph[i][1]] = true;
                dfs(graph, graph[i][1], vis);
            }
        }
    }


    public static void main(String[] args) {
        int[][] g = new int[][]{
                {0, 1}, {0, 2}, {1, 2}, {1, 2}
        };
        System.out.println(findWhetherExistsPath(3, g, 0, 2));
    }
}
