package com.raptor.interview.Twangyi;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int ans1 = 0;
            int ans2 = 0;
            int ans3 = 0;
            //全部使用x
            ans1 = (a + b) % x == 0 ? (a + b) / x : (a + b) / x + 1;
            //全用y
            ans2 = (a + b) % y == 0 ? (a + b) / y : (a + b) / y + 1;
            while (a >= 0 && b >= 0) {
                ans3++;
                a -= y;
                b -= y;
            }
            int live = Math.max(a, b);
            live = Math.max(0, live);
            int temp1 = (live % x == 0 ? live / x : live / x + 1);
            int temp2 = (live % y == 0 ? live / y : live / y + 1);
            ans3+=Math.max(temp1,temp2);
            System.out.println(Math.min(ans1, Math.min(ans2, ans3)));
        }
    }
}
