package com.enternal.greddy;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Filter;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/19  20:13
 */
public class LemonadeChange {

    public static boolean lemonadeChange(int[] bills) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                a++;
            } else if (bills[i] == 10) {
                if (a == 0) {
                    return false;
                } else {
                    a--;
                    b++;
                }
            } else {
                if (b > 0 && a > 0) {
                    b--;
                    a--;
                } else if (b == 0 && a >= 3) {
                    a-=3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = new int[]{5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(bills));
    }
}

