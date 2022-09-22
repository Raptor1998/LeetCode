package com.enternal.mayi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            for (int i = 0; i < q; i++) {
                int t = scanner.nextInt();
                int index = scanner.nextInt();
                int x = scanner.nextInt();
                if (t == 1){
                    nums[index-1] = x;
                }else {
                    int ans = 0;
                    for (int j = 0; j < index; j++) {
                        if (x == nums[j]){
                            ans ++;
                        }
                    }
                    System.out.println(ans);
                }
            }
        }
    }
}
