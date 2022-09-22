package com.enternal.mayi;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n <= 2) {
                System.out.println(-1);
            } else {
                int[][] map = new int[n][n];
                map[0][0] = 1;
                int temp = 0;
                int sub = 1;
                for (int i = 1; i < n; i++) {
                    temp += 2;
                    map[0][i] = temp;
                }
                for (int i = 1; i < n; i++) {
                    temp += 2;
                    map[i][0] = temp;
                }
                push(map,n,temp,sub);
                show(map, n);

            }
        }
    }

    public static void push(int[][] map, int n, int temp, int sub) {
        int nn = n * n;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int num = judge(map, n, i, j);
                System.out.println(i + " " +j+ " " + num);
                if (temp+2 <= nn && num == 1 || num == 3){
                    temp+=2;
                    map[i][j] = temp;
                }else{
                    if (sub + 2 < nn){
                        sub+=2;
                        map[i][j] = sub;
                    }
                }
            }
        }
    }

    public static void show(int[][] map, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int judge(int[][] map, int n, int i, int j) {
        if (i - 1 < 0 || j - 1 < 0 || i >= n || j >= n) {
            return 0;
        } else {
            int js = 0;
            if (map[i - 1][j - 1] % 2 == 1) {
                js++;
            }
            if (map[i - 1][j] % 2 == 1) {
                js++;
            }
            if (map[i][j - 1] % 2 == 1) {
                js++;
            }
            return js;
        }
    }
}
