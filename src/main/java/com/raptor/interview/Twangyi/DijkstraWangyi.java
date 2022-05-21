package com.raptor.interview.Twangyi;

import java.util.Scanner;

public class DijkstraWangyi {
    public static int MaxValue = 1000000 * 2 + 5;

    public static int dijstra(int[][] matrix, int source, int end) {
        //最短路径长度
        int[] shortest = new int[matrix.length];
        //判断该点的最短路径是否求出
        int[] visited = new int[matrix.length];
        //初始化源节点
        shortest[source] = 0;
        visited[source] = 1;
        for (int i = 1; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < matrix.length; j++) {
                //已经求出最短路径的节点不需要再加入计算并判断加入节点后是否存在更短路径
                if (visited[j] == 0 && matrix[source][j] < min) {
                    min = matrix[source][j];
                    index = j;
                }
            }
            //更新最短路径
            shortest[index] = min;
            visited[index] = 1;
            //更新从index跳到其它节点的较短路径
            for (int m = 0; m < matrix.length; m++) {
                if (visited[m] == 0 && matrix[source][index] + matrix[index][m] < matrix[source][m]) {
                    matrix[source][m] = matrix[source][index] + matrix[index][m];
                }
            }

        }
        if (shortest[end] == MaxValue) {
            return -1;
        } else {
            return shortest[end];
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][n];
        int[][] edges = new int[m][3];
        //初始化邻接矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = MaxValue;
            }
        }
        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
            edges[i][2] = scanner.nextInt();
            map[edges[i][0] - 1][edges[i][1] - 1] = edges[i][2];
        }

        //单源最短路径，源点
        int source = 0;
        int ans = Integer.MAX_VALUE;
        //遍历修改每一条边  求单源最短路径
        for (int i = 0; i < m; i++) {
            map[edges[i][1] - 1][edges[i][0] - 1] = edges[i][2];
            int dijstra = dijstra(map, source, n - 1);
            ans = Math.min(ans, dijstra);
            map[edges[i][1] - 1][edges[i][0] - 1] = MaxValue;
        }
        System.out.println(ans);
    }
}
/*
3 3
1 2 3
2 3 5
3 1 4


4 3
1 2 2
1 3 4
2 3 6
 */