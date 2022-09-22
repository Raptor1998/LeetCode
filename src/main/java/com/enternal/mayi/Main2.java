package com.enternal.mayi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            String k = scanner.next();

            int kk = Integer.parseInt(k);
            int n = s.length();
            int l = k.length();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (j - i < l) {
                        ans++;
                    } else if (j - i == l) {
                        String temp = s.substring(i,j);
                        int parseInt = Integer.parseInt(temp);
                        if (parseInt < kk){
                            ans++;
                        }
                    } else {
                        break;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
