package com.raptor.interview.Tmeituan;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int nums[] = new int[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
                if (nums[i]>0){
                    ans++;
                }
            }

            // O(n3)
            int mutis[] = new int[n];
            for (int i = 0; i < n; i++) {
                mutis[i] = nums[i];
                for (int j = i+1; j < n; j++) {
                    mutis[j] = mutis[j-1] * nums[j];
                    if (mutis[j] > 0){
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
