package com.raptor.interview.Twangyi;

import java.time.Year;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main3 {
    static int n;
    static int m;
    public static int[][] d = {{-1, 0}, {0, 1}, {1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }
            System.out.println(bfs(map));
        }
    }


    public static int bfs(int[][] map) {
        boolean[][] vis = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(0, 0, 0);
        queue.add(node);
        vis[0][0] = true;
        while (!queue.isEmpty()) {
            node = queue.poll();
            for (int i = 0; i < 3; i++) {
                Node t = new Node();
                t.x = node.x;
                t.y = node.y;
                t.t = node.t;
                t.x = node.x + d[i][0];
                t.y = node.y + d[i][1];
                if (t.x < 0 || t.y < 0 || t.x > n - 1 || t.y > m - 1) {
                    continue;
                }
                if (vis[t.x][t.y]) {
                    continue;
                }

                if (map[t.x][t.y] == map[node.x][node.y]) {
                    t.t += 1;
                } else if (map[t.x][t.y] != map[node.x][node.y]) {
                    t.t += 2;
                } else if (t.x == n - 1 && t.y == m - 1) {
                    return t.t;
                }
                queue.add(t);
                vis[t.x][t.y] = true;
            }
        }
        return -1;
    }

    static class Node {
        int x;
        int y;
        int t;

        public Node() {
        }

        public Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}
