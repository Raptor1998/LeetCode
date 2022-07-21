package com.enternal.greddy;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/19  22:41
 */
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return n;
        }
        int ans = 0;
        int presub = nums[1] - nums[0];
        if (presub == 0){
            ans++;
        }else {
            ans+=2;
        }
        for (int i = 2; i < n; i++) {
            int sub = nums[i] - nums[i - 1];
            if ((sub < 0 && presub >= 0) || (sub > 0 && presub <= 0)) {
                presub = sub;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{
                1, 17, 5, 10, 13, 15, 10, 5, 16, 8
        };
        System.out.println(new WiggleMaxLength().wiggleMaxLength(a));
    }
}
