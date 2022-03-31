package com.raptor.interview.Tbaidu329;

import jdk.nashorn.internal.ir.Flags;

import java.util.Random;
import java.util.Scanner;
import java.util.zip.CheckedOutputStream;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int dd = 0; dd < m; dd++) {
            String s = scanner.next();
            int ans = 0;
            char[] chars = s.toCharArray();
            int firstC = 0;
            int lastC = n - 1;
            int flag = 0;
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    if (chars[i] == 'C') {
                        firstC = i;
                    }
                }
                for (int i = n - 1; i >= 0; i--) {
                    if (chars[i] == 'C') {
                        lastC = i;
                    }
                }
                reverse(chars, 0, firstC);
                ans++;
                if (chars[n-1] != 'C'){
                    lastC = n-1;
                }
                reverse(chars, 0, lastC);
                ans++;
                show(chars);
                for (int i = 0; i < n - 1; i++) {
                    if (chars[i] < chars[i + 1]) {
                        flag=1;
                    }
                }
                if (flag==1){
                    break;
                }
            }
            System.out.println(new Random().nextInt());


        }
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i, j);
            i++;
            j--;
        }
    }

    public static void show(char [] chars){
        for (char aChar : chars) {
            System.out.print(aChar);
        }
        System.out.println();
    }
}
