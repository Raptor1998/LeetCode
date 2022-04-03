package com.raptor.chapter.dfs;

import java.util.*;

/**
 * @author raptor
 * @description T827
 * @date 2022/4/1 9:24
 */


//超时
public class T827 {
    class Node {
        int x;
        int y;

        public Node() {
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int[][] clone(int[][] grid) {
        int[][] clone = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                clone[i][j] = grid[i][j];
            }
        }
        return clone;
    }

    public int largestIsland(int[][] grid) {
        int max_area = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean hasZero = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    grid[i][j] = 1;
                    max_area = Math.max(max_area, maxAreaOfIsland(grid, i, j));
                    grid[i][j] = 0;
                }
            }
        }
        return hasZero ? max_area : n * n;
    }

    public void show(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }


    public int maxAreaOfIsland(int[][] grid, int i, int j) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int n = grid.length;
        int m = grid[0].length;
        int max_area = 0;
        int temp_area;
        Queue<Node> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        Node node = new Node(i, j);
        queue.add(node);
        temp_area = 1;
        vis[i][j] = true;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = poll.x + dx[k];
                int y = poll.y + dy[k];
                if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1 && !vis[x][y]) {
                    temp_area += 1;
                    Node node1 = new Node(x, y);
                    queue.add(node1);
                    vis[x][y] = true;
                }
            }
        }
        max_area = Math.max(max_area, temp_area);
        return max_area;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1},
                {1, 1},
        };
        System.out.println(new T827().largestIsland(grid));
    }
}
