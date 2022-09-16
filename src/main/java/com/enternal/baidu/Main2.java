package com.enternal.baidu;

import java.util.Scanner;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/9/13  19:46
 */
public class Main2 {
    static long ans = 0;
    static int n = 0;
    static int[] s1;
    static int[] s2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            s1 = new int[n];
            s2 = new int[n];
            for (int i = 0; i < n; i++) {
                s1[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                s2[i] = scanner.nextInt();
            }
            long[][] dp = new long[n + 1][n + 1];
            System.out.println(ans);
        }

    }
    public static void dfs(int pre, long now, int index) {
        if (index == n) {
            ans = Math.max(ans, now);
            return;
        }
        //没吃
        if (pre == 0) {
            dfs(1, now + s1[index], index + 1);
            dfs(2, now + s2[index], index + 1);
        }else if (pre == 1){
            dfs(2,now + s2[index],index + 1);
            dfs(0,now,index + 1);
        }else {
            dfs(1,now + s1[index],index + 1);
            dfs(0,now,index + 1);
        }
    }

}
