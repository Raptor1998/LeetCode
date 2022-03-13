package com.raptor.interview.Tmeituan;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int t = scanner.nextInt();
                if (isMutiEleven(t) || isContainTwo(t)){
                    System.out.println("yes");
                }else {
                    System.out.println("no");
                }
            }
        }
    }

    public static boolean isMutiEleven(int x){
        if (x % 11 != 0){
            return false;
        }
        return true;
    }

    public static boolean isContainTwo(int x){
        int temp = x;
        int num = 0;
        while (temp>0){
            int single = temp % 10;
            if (single==1){
                num++;
            }
            temp = temp/10;
        }
        if (num>=2){
            return true;
        }else {
            return false;
        }
    }
}
