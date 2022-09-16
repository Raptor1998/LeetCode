package com.enternal.baidu;

import java.util.Scanner;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/9/13  19:31
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int t = scanner.nextInt();
            long[] time1 = new long[n];
            long[] time2 = new long[m];

            long[] sum1 = new long[n];
            long[] sum2 = new long[m];
            for (int i = 0; i < n; i++) {
                time1[i] = scanner.nextInt();
                if (i == 0 ){
                    sum1[i] = time1[i];
                }else {
                    sum1[i] = sum1[i-1] + time1[i];
                }
            }
            for (int i = 0; i < m; i++) {
                time2[i] = scanner.nextInt();
                if (i == 0 ){
                    sum2[i] = time2[i];
                }else {
                    sum2[i] = sum2[i-1] + time2[i];
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (sum1[i] + sum2[j] <= t){
                        ans = Math.max(ans,i + j + 2);
                    }else {
                        break;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
