package com.enternal.T360;

import java.awt.image.TileObserver;
import java.util.Scanner;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/9/9  14:41
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int temp = 1;
                int high = nums[i];
                int left = i-1;
                int right = i+1;
                while (left>=0){
                    if (high > nums[left] && nums[left] < nums[left+1]){
                        left--;
                        temp++;
                    }else {
                        break;
                    }
                }
                while (right<n){
                    if (high > nums[right] && nums[right] < nums[right-1]){
                        right++;
                        temp++;
                    }else {
                        break;
                    }
                }
                ans = Math.max(temp,ans);
            }
            System.out.println(ans);
        }

    }
}
