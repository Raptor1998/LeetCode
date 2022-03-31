package com.raptor.chapter.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class T695 {
    class Node {
        int x;
        int y;

        public Node() {
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int n = grid.length;
        int m = grid[0].length;
        int max_area = 0;
        int temp_area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    Queue<Node> queue = new LinkedList<>();
                    Node node = new Node(i, j);
                    queue.add(node);
                    grid[i][j] = 0;
                     temp_area = 1;
                    while (!queue.isEmpty()) {
                        Node poll = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = poll.x + dx[k];
                            int y = poll.y + dy[k];
                            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1) {
                                temp_area += 1;
                                Node node1 = new Node(x, y);
                                queue.add(node1);
                                grid[x][y]=0;
                            }
                        }
                    }
                }
                max_area=Math.max(max_area,temp_area);
            }
        }
        return max_area;
    }


    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(new T695().maxAreaOfIsland(grid));
    }
}
