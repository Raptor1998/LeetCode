package com.raptor.interview.Tmeituan;

import java.util.Scanner;

/**
 * @author raptor
 * @description Solution2
 * @date 2022/3/19 11:01
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int t = scanner.nextInt();
            String s = scanner.next();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(s);
            int length = stringBuffer.length();
            StringBuffer ans = new StringBuffer();
            while (length > 0) {
                int pos = 0;
                if (length % 2 == 0) {
                    pos = length / 2;
                } else {
                    pos = length / 2 + 1;
                }
                System.out.println(pos);
                char c = stringBuffer.charAt(pos);
                ans.append(c);
                stringBuffer.replace(pos-1, pos, "");
                System.out.println("string:"+ stringBuffer.toString());
            }
            System.out.println(ans.toString());
        }
    }
}
