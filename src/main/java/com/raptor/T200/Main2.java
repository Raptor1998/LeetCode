package com.raptor.T200;


import com.raptor.chapter.dfs.MinSpeedTime;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/9/7  20:20
 */
public class Main2 {
    public static void main(String[] args) {
        int [][] map = {
                {1,2,0},
                {0,2,0},
                {0,0,3}
        };
        m = 3;
        n = 3;
        boolean [][] vis = new boolean[3][3];
        vis[0][0] = true;
        Node startNode = new Node(0, 0, 0,-1);
        queue.add(startNode);
        System.out.println(bfs(map,vis) - 1);
    }

    static int dis = 4;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static Queue<Node> queue = new LinkedList<>();
    static int m;
    static int n;

    public static int bfs(int[][] map, boolean[][] vis) {
        while (!queue.isEmpty()) {
            Node pollNode = queue.poll();
            for (int i = 0; i < dis; i++) {
                Node temp = new Node(pollNode.x, pollNode.y, pollNode.time,i);
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
                if (i != pollNode.nowi && map[temp.x][temp.y] == 0){
                        temp.time+=2;
                }else {
                    if (map[temp.x][temp.y] == 0) {
                        temp.time++;
                    }
                }
                if (i != pollNode.nowi && map[temp.x][temp.y] == 3){
                        return temp.time + 2;
                }else {
                    if (map[temp.x][temp.y] == 3) {
                        return temp.time + 1;
                    }
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

        int nowi;

        public Node() {
        }

        public Node(int x, int y, int time,int nowi) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.nowi = nowi;
        }
    }
}
