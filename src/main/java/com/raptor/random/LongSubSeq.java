package com.raptor.random;

import com.raptor.base.day5.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raptor
 * @description LongSubSeq
 * @date 2022/2/15 11:33
 */
public class LongSubSeq {
    public static int longSeq(int[] s) {
        int n = s.length;
        int dp[] = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int index = -1;
        List<List<Integer>> paths = new ArrayList<>();
        int max = -1;
        for (int i = 0; i < n; i++) {
            List<Integer> temp1 = new ArrayList<>();
            temp1.add(s[i]);
            paths.add(temp1);
            for (int j = i - 1; j >= 0; j--) {
                if (s[i] > s[j]) {
                    //dp[i] = Math.max(dp[j] + 1, dp[i]);
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        List<Integer> temp = new ArrayList<>(paths.get(j));
                        temp.add(s[i]);
                        paths.remove(i);
                        paths.add(temp);
                    }
                }
            }
            if (dp[i] >= max) {
                max = dp[i];
                index = i;
            }

            for (int item : dp) {
                System.out.print(item + " ");
            }
            System.out.println();
        }


        List<Integer> list = paths.get(index);
        for (Integer integer : list) {
            System.out.println(integer);
        }

        return max;
    }

    public static int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }

    public static int findNumberOfLIS(int[] s) {
        int n = s.length;
        if (n == 0 || n == 1) {
            return n;
        }
        int dp[] = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int max = -1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (s[i] > s[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if (dp[i] >= max) {
                max = dp[i];
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max - 1) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int a[] = new int[]{7, 8, 9, 10, 1, 2, 4};
        System.out.println("------");
        System.out.println(longSeq(a));
    }
}
