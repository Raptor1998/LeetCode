package com.raptor.interview.TJD;

import java.util.Scanner;

/**
 * @author raptor
 * @description Solution1
 * @date 2022/3/19 19:40
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            //总血量
            int tempB = d * b;
            int ans = 0;
            while (a >= 0) {
                //轮数
                ans++;
                //剩余的总血量
                tempB -= (a);
                if (tempB <= 0) {
                    System.out.println(ans);
                    return;
                }
                //剩余的碉堡
                d = tempB % b == 0 ? tempB / b : tempB / b + 1;
                //剩余的坦克
                a -= (c * d);
            }
            if (tempB > 0) {
                System.out.println(-1);
            }
        }
    }
}
