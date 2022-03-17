package com.raptor.interview.Tali;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(s);
            String substring = stringBuffer.substring(2, stringBuffer.length());
            int ans = 0;
            int[] num = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
            for (int i = 0; i < substring.length(); i++) {
                char c = substring.charAt(i);
                if (c >= '0' && c <= '9') {
//                    System.out.println(c+":"+(c-'0'));
                    ans += num[c - '0'];
                }else {
//                    System.out.println(c+":"+(c-'a'));
                    ans+=num[c-'a'+10];
                }
            }
            System.out.println(ans);
        }
    }
}
