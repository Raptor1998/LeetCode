package com.enternal.wangyi;

import java.util.Scanner;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/9/4  15:22
 */
public class Main2 {
    static String ans = "-1";
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int t = scanner.nextInt();
//            flag = false;
//            StringBuilder stringBuilder = new StringBuilder();
//            findAllString(0, 0, 0, stringBuilder, n, k, t);
            System.out.println(solve(n,k,t));
        }
    }

    public static String solve(int n,int k,int t){
        StringBuilder stringBuilder = new StringBuilder();
        if (t == 0){
            if (k > n / 2){
                return "-1";
            }else {
                for (int i = 0; i < k; i++) {
                    stringBuilder.append("10");
                }
                for (int i = stringBuilder.length(); i < n; i++) {
                    stringBuilder.append('0');
                }
                return stringBuilder.toString();
            }
        }else {
            if (k < t  + 1){
                return "-1";
            }else {

                for (int i = 0; i < t+1; i++) {
                    stringBuilder.append('1');
                }
                int sub = k - t - 1;
                for (int i = stringBuilder.length(); i < n; i++) {
                    stringBuilder.append('0');
                    if (sub > 0){
                        stringBuilder.append('1');
                        sub --;
                    }
                }
                return stringBuilder.toString();
            }

        }
    }

    public static String findString(int n,int k,int t){
        StringBuilder stringBuilder = new StringBuilder();
        int x = 2 * t - k + 2;
        int y = k -x;
        if (x < 0 || y < 0){
            return "-1";
        }
        int zero = n - x - y;
        int need_zero = 0;
        if (x > 0 && y > 0){
            need_zero = y /2 ;
        }else if (x > 0 ){
            need_zero = 0;
        }else {
            need_zero = y /2 -1;
        }
        if (zero < need_zero){
            return "-1";
        }


        for (int i = 0; i < x; i++) {
            stringBuilder.append('1');
        }
        if (x > 0){
            stringBuilder.append('0');
            --zero;
        }
        for (int i = 0; i < y / 2 ; i++) {
            stringBuilder.append("11");
            if (zero > 0){
                --zero;
                stringBuilder.append('0');
            }
        }

        while (zero-- != 0){
            stringBuilder.append('0');
        }
        return stringBuilder.toString();
    }

    public static void findAllString(int nowN, int nowK, int nowT, StringBuilder stringBuilder, int n, int k, int t) {
        if (flag) {
            return;
        }
        if (nowN == n && nowK == k && nowT == t) {
            ans = stringBuilder.toString();
            flag = !flag;
            return;
        }
        if (nowN > n || nowK > k || nowT > t) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                stringBuilder.append("0");
                findAllString(nowN + 1, nowK, nowT, stringBuilder, n, k, t);
                stringBuilder.deleteCharAt(nowN);
            } else {
                stringBuilder.append("1");
                if (nowN == 0 || stringBuilder.charAt(nowN - 1) == '0') {
                    findAllString(nowN + 1, nowK + 1, nowT, stringBuilder, n, k, t);
                } else {
                    findAllString(nowN + 1, nowK + 1, nowT + 1, stringBuilder, n, k, t);
                }
                stringBuilder.deleteCharAt(nowN);
            }
        }
    }
}
