package com.raptor.interview.Tali;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int map[][] = new int[n][m];
            int rowSum[] = new int[n];
            //记录每一行的和
            int columnSum[] = new int[m];
            int rowLeftSum [][] = new int[n][m];
            int ans = 0;
            int i ,j;
            int columnTopSum [][] = new int[n][m];
            for (i = 0; i < n; i++) {
                for (j = 0; j < m; j++) {
                    map[i][j] = scanner.nextInt();
                    rowSum[i] += map[i][j];
                    columnSum[j] += map[i][j];
                    if (map[i][j]==0){
                        rowLeftSum[i][j] = rowSum[i];
                        columnTopSum[i][j] = columnSum[j];
                    }
                    if (rowLeftSum[i][j]>0){
                        ans++;
                    }
                    if (columnTopSum[i][j]>0){
                        ans++;
                    }

                }
                if (rowSum[i] - rowLeftSum[i][j] > 0) {
                    ans++;
                }
                if (columnSum[j] - columnTopSum[i][j] > 0) {
                    ans++;
                }
            }
            /*
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        int leftRowSum = 0;
                        int topColumnSumm = 0;
                        //System.out.println((i+1)+"行，"+(j+1)+"列；行和："+rowSum[i]+",左前缀:"+leftRowSum[i]+",列和："+columnSum[j]+",上前缀："+topColumnSumm[j]);
//                        for (int k = 0; k < j; k++) {
//                            leftRowSum += map[i][k];
//                        }
//                        for (int k = 0; k < i; k++) {
//                            topColumnSumm += map[k][j];
//                        }
//                        if (leftRowSum > 0) {
//                            ans++;
//                        }
//                        if (topColumnSumm > 0) {
//                            ans++;
//                        }
                        if (rowLeftSum[i][j]>0){
                            ans++;
                        }
                        if (rowSum[i] - rowLeftSum[i][j] > 0) {
                            ans++;
                        }
                        if (columnTopSum[i][j]>0){
                            ans++;
                        }
                        if (columnSum[j] - columnTopSum[i][j] > 0) {
                            ans++;
                        }
                    }
                }
            }
            */
            System.out.println(ans);
        }
    }
}
