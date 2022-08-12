package com.raptor.interview.Tmeituan;

import java.util.Scanner;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/6  10:08
 */
public class GiftBox {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int k = 0; k < T; k++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int ans = x < y ?
                    Math.min(x, (y & 1) == 0 ? y / 2 : y / 2 + 1)
                    :
                    Math.min((x & 1) == 0 ? x / 2 : x / 2 + 1, y);
            System.out.println(ans);
        }
    }
}
