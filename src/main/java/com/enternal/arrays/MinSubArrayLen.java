package com.enternal.arrays;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/11  21:10
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int st = 0;
        int end = 0;
        int sum = 0;
        while (end<n){
            sum += nums[end];
            while (sum>=target){
                ans = Math.min(ans,end - st + 1);
                sum -= nums[st];
                st++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{2,3,1,2,4,3};
        System.out.println(new MinSubArrayLen().minSubArrayLen(7,nums));
    }
}
