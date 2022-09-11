package com.enternal.T360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/9/9  15:45
 */
public class Main2 {
//    static List<Integer> path;
    static long ans = 0l;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] start = new int[m];
            int[] end = new int[m];
            int[] weight = new int[m];
            for (int i = 0; i < m; i++) {
                start[i] = scanner.nextInt();
            }
            for (int i = 0; i < m; i++) {
                end[i] = scanner.nextInt();
            }
            for (int i = 0; i < m; i++) {
                weight[i] = scanner.nextInt();
            }
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
//            path = new ArrayList<>();
            ans = 0l;
            for (int i = 0; i < m; i++) {
                map[start[i]-1][end[i]-1] = weight[i];
                map[end[i]-1][start[i]-1] = weight[i];
            }
            prime(n,map);
            System.out.println(ans);
        }
    }

    public static void prime(int n,int[][] map){
        int[] tempWeight = new int[n];
        int minWeight;
        int minId;
        long sum = 0l;
        for (int i = 0; i < n; i++) {
            tempWeight[i] = map[0][i];
        }
//        path.add(0);
        for (int i = 1; i < n; i++) {
            minWeight = Integer.MAX_VALUE;
            minId = 0;
            for (int j = 1; j < n; j++) {
                if (tempWeight[j] > 0 && tempWeight[j] < minWeight){
                    minWeight = tempWeight[j];
                    minId = j;
                }
            }
//            path.add(minId);
            sum += minWeight;
            tempWeight[minId] = 0;
            for (int j = 1; j < n; j++) {
                if (tempWeight[j] != 0 && map[minId][j] < tempWeight[j]){
                    tempWeight[j] = map[minId][j];
                }
            }
        }
        ans = sum;
    }

}
