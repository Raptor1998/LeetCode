package com.raptor.chapter.fenzhi;

import java.util.Arrays;

public class T1838 {
    public static int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int max = 1;
        int i, j;
        for (i = 0; i < n; i++) {
            if (i> 0 && nums[i] == nums[i-1]){
                continue;
            }
            int tk = k;
            for (j = i - 1; j >= 0; j--) {

                if (tk >= (nums[i] - nums[j])) {
                    tk -= (nums[i] - nums[j]);
                } else {
                    break;
                }
            }
            max = Math.max(max, i - j);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,9,6};
        System.out.println(maxFrequency(nums, 2));
    }
}
