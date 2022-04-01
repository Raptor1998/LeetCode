package com.raptor.chapter.dfs;

import java.beans.Visibility;
import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author raptor
 * @description MinSpeedTime
 * @date 2022/3/30 19:05
 */
public class MinSpeedTime {
    static int dis = 4;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static Queue<Node> queue = new LinkedList<>();
    static int m;
    static int n;
    static int endX;
    static int endY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        // 1 起点   2 阻挡   3  终点
        int[][] map = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        map[startX][startY] = 1;
        Node startNode = new Node(startX, startY, 0);
        queue.add(startNode);
        vis[startX][startY] = true;
        endX = scanner.nextInt();
        endY = scanner.nextInt();
        map[endX][endY] = 3;
        int lake = scanner.nextInt();
        for (int i = 0; i < lake; i++) {
            int lakeX = scanner.nextInt();
            int lakeY = scanner.nextInt();
            map[lakeX][lakeY] = 2;
        }
        System.out.println("地图:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        bfs(map, vis);

    }


    //最短路径
    public static int bfs(int[][] map, boolean[][] vis) {
        while (!queue.isEmpty()) {
            Node pollNode = queue.poll();
            for (int i = 0; i < dis; i++) {
                Node temp = new Node(pollNode.x, pollNode.y, pollNode.time);
                temp.x += dx[i];
                temp.y += dy[i];
                //越界
                if (temp.x < 0 || temp.y < 0 || temp.x > m - 1 || temp.y > n - 1) {
                    continue;
                }
                //走过 或者 为湖泊
                if (vis[temp.x][temp.y] || map[temp.x][temp.y] == 2) {
                    continue;
                }
                //可行
                if (map[temp.x][temp.y] == 0) {
                    temp.time++;
                }
                //到达终点
                if (map[temp.x][temp.y] == 3) {
                    return temp.time + 1;
                }
                queue.add(temp);
                vis[temp.x][temp.y] = true;
            }
        }

        //找不到路
        return -1;
    }

    static class Node {
        int x;
        int y;
        int time;

        public Node() {
        }

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
