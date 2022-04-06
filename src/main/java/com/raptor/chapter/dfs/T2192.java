package com.raptor.chapter.dfs;

import java.util.*;

public class T2192 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> original = new ArrayList<>();
            boolean[] vis = new boolean[n];
            dfs(edges, i, vis);

            for (int j = 0; j < n; j++) {
                if (vis[j]==true){
                    original.add(j);
                }
            }

            Collections.sort(original);
            ans.add(original);


        }
        return ans;
    }

    public void dfs(int[][] edges, int nowNode, boolean[] vis) {
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == nowNode) {
                if (!vis[edges[i][0]]) {
                    vis[edges[i][0]] = true;
                    dfs(edges, edges[i][0], vis);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] edges = {
                {0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}
        };
        List<List<Integer>> ancestors = new T2192().getAncestors(8, edges);
        for (List<Integer> ancestor : ancestors) {
            for (Integer integer : ancestor) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
