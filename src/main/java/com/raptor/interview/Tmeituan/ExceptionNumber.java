package com.raptor.interview.Tmeituan;

import java.net.NetworkInterface;
import java.util.Scanner;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/6  10:37
 */
public class ExceptionNumber {
    /*
5
0 -1 1 1 -1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            //以 i 为结尾的  负数个数
            int[] negative = new int[n];
            int[] zero = new int[n];
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                int t = scanner.nextInt();
                nums[i] = t;
                if (i == 0) {
                    if (t < 0) {
                        negative[0] = 1;
                    } else if (t == 0) {
                        zero[0] = 1;
                    }
                } else if (i > 0) {
                    if (t < 0) {
                        negative[i] = negative[i - 1] + 1;
                        zero[i] = zero[i-1];
                    } else if (t == 0){
                        zero[i] = zero[i-1] + 1;
                    }else {
                        zero[i] = zero[i-1];
                        negative[i] = negative[i - 1];
                    }
                }
            }
            int ans = Integer.MAX_VALUE;
            //遍历 k位置
            for (int i = 0; i < n; i++) {
                //k 左边的  大于等于0的
                int pos_left = Math.max(i - negative[i] + zero[i], 0);
                //k 右边的  小于等于0的
                int neg_right = negative[n - 1] - negative[i]
                        + zero[n-1] - zero[i];
                ans = Math.min(pos_left + neg_right, ans);
            }
            System.out.println(ans);
        }
    }
}
