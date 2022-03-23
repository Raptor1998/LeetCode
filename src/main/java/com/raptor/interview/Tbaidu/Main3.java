package com.raptor.interview.Tbaidu;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static int MaxValue = 100000;
    public static int[][] path;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int s = sc.nextInt();
        int[][] map = new int[n][n];
        int[][] oldMap = new int[n][n];
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            map[start][end] = weight;
            oldMap[start][end] = weight;
        }
        for (int i = 0; i < k; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            map[start][end] = weight;
            oldMap[start][end] = weight;
            map[end][start] = weight;
            oldMap[end][start] = weight;
        }
        int timeA = sc.nextInt();
        int timeB = sc.nextInt();
        int p = sc.nextInt();
        int[] queue = new int[p];
        for (int i = 0; i < p; i++) {
            queue[i] = sc.nextInt();
        }
        int pathTime = 0;
        int disTime = 0;
        int[][] dist = new int[n + 1][n + 1];
        int[][] pre = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(pre[i], i);
        }
        path = new int[n][n];
        floyd(map);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }


    //非递归实现
    public static void floyd(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                path[i][j] = -1;
            }
        }

        for (int m = 0; m < matrix.length; m++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][m] + matrix[m][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][m] + matrix[m][j];
                        //记录经由哪个点到达
                        path[i][j] = m;
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i != j) {
                    if (matrix[i][j] == MaxValue) {
                        System.out.println(i + "到" + j + "不可达");
                    } else {
                        System.out.print(i + "到" + j + "的最短路径长度是：" + matrix[i][j]);
                        System.out.print("最短路径为：" + i + "->");
                        findPath(i, j);
                        System.out.println(j);
                    }
                }
            }
        }
    }

    //递归寻找路径
    public static void findPath(int i, int j) {
        int m = path[i][j];
        if (m == -1) {
            return;
        }

        findPath(i, m);
        System.out.print(m + "->");
        findPath(m, j);
    }
}
/*
3 0 3 1
0 1 3
2 1 6
0 2 9
6 3 3
1 2 3


 */