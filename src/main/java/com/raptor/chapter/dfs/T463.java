package com.raptor.chapter.dfs;

import java.util.Map;

public class T463 {
    public int islandPerimeter(int[][] grid) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        int repeat = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ans++;
                    for (int k = 0; k < 4; k++) {
                        int newI = i + dx[k];
                        int newJ = j + dy[k];
                        if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && grid[newI][newJ] == 1) {
                            repeat++;
                        }
                    }
                }
            }
        }
        return ans*4 - repeat;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        System.out.println(new T463().islandPerimeter(grid));
    }
}
