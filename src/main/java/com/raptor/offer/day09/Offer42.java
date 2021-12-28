package com.raptor.offer.day09;

/**
 * @author raptor
 * @description Offer42
 * @date 2021/12/28 16:13
 */
public class Offer42 {
    public static int maxSubArray1(int[] nums) {
        //前缀和方法
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        int sum = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            ans = Math.max(ans, sum - min);
            //最小的和值
            if (sum<min){
                min = sum;
            }
        }
        return ans;
    }
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
