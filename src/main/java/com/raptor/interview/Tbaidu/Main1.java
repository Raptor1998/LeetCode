package com.raptor.interview.Tbaidu;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int[][] ans = new int[n * k][n * k];
        for (int i = 0; i < n * k; i++) {
            for (int j = 0; j < n * k; j++) {
                ans[i][j]  = map[i/k][j/k];
            }
        }
        for (int i = 0; i < n*k; i++) {
            for (int j = 0; j < n*k; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }

    }
}
