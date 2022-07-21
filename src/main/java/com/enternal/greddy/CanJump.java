package com.enternal.greddy;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/20  23:17
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int now = 0;
        for (int i = 0; i < n; i++) {
            //当前最远下标超过了 实际下标
            if (i <= now){
                //更新能达到的最远下标
                now = Math.max(now,i+nums[i]);
            }
            if(now >= n-1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CanJump().canJump(new int[]{2,3,1,1,4}));
    }
}
