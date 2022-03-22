package com.raptor.interview.Tmeituan;

import java.security.PublicKey;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author raptor
 * @description Soultion1
 * @date 2022/3/19 10:14
 */
public class Soultion1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //第一行输入
            int n = scanner.nextInt();
            int[] price = new int[n];
            //原价
            for (int i = 0; i < n; i++) {
                price[i] = scanner.nextInt();
            }
            int[] discount = new int[n];
            //折扣输入
            for (int i = 0; i < n; i++) {
                discount[i] = scanner.nextInt();
            }
            //第四行输入
            int m = scanner.nextInt();
            int[] enough = new int[m];
            //满减条件
            for (int i = 0; i < m; i++) {
                enough[i] = scanner.nextInt();
            }
            int[] subtract = new int[m];
            //满减  额度
            for (int i = 0; i < m; i++) {
                subtract[i] = scanner.nextInt();
            }
            String ans = solution(n, price, discount, m, enough, subtract);
            System.out.println(ans);
        }
    }

    // n 是第一行输入    price 第二行   discount 第三行
    // m  第四行   enough 第五航   subtract第六航
    public static String solution(int n, int[] price, int[] discount, int m, int[] enough, int[] subtract) {
        int sum = 0;
        int discountSum = 0;
        StringBuffer ans = new StringBuffer();
        //遍历所有商品
        for (int i = 0; i < n; i++) {
            //当前原价格
            sum += price[i];
            //折扣价格
            discountSum += discount[i];
            //满减价格
            int tempM = sum;
            //是否满减
            for (int j = 0; j < m; j++) {
                if (sum >= enough[j]) {
                    tempM = Math.min(tempM, sum - subtract[j]);
                }
            }
            if (discountSum == tempM) {
                ans.append("B");
            } else if (discountSum < tempM) {
                ans.append("Z");
            } else {
                ans.append("M");
            }
        }
        return ans.toString();
    }
}
