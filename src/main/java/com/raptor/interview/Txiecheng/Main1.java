package com.raptor.interview.Txiecheng;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            StringBuffer buffer = new StringBuffer();
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c=='>'||c=='<'||c=='='){
                    buffer.append(" "+c+" ");
                }else if (c==' '){
                    continue;
                }else {
                    buffer.append(c);
                }
            }
            System.out.println(buffer.toString());
        }
    }
}
