package com.raptor.interview.Tbaidu329;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int maxValue = 0;
            for (int i = 1; i <= k; i++) {
                int temp = n * i;
                int reverse = reverse(temp);
                maxValue = Math.max(maxValue,reverse);
            }
            System.out.println(maxValue);
        }
    }
    public static int reverse(int t){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(t);
        String s = stringBuffer.reverse().toString();
        return Integer.parseInt(s);
    }
}
