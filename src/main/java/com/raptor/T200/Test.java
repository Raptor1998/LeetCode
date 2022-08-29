package com.raptor.T200;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean flag = true;
        int oddMax = 0, evenMax = 0;
        HashMap<Integer, Integer> oddMap = new HashMap<>();
        HashMap<Integer, Integer> evenMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (flag) {
                Integer temp = oddMap.get(x);
                temp = temp == null ? 1 : ++temp;
                oddMap.put(x, temp);
                oddMax = Math.max(oddMax, temp);
            } else {
                Integer temp = evenMap.get(x);
                temp = temp == null ? 1 : ++temp;
                evenMap.put(x, temp);
                evenMax = Math.max(evenMax, temp);
            }
            flag = !flag;
        }
        System.out.println(n - oddMax - evenMax);
    }

}
