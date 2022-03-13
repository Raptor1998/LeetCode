package com.raptor.interview.T360;

import java.util.Scanner;

class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            double temp=n;
            double sum = n;
            for (int i = 0; i < m-1; i++) {
                temp=Math.sqrt(temp);
                sum += temp;
            }
            System.out.println(String.format("%.2f",sum));
        }
    }
}
