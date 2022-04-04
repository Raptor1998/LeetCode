package com.raptor.chapter.fenzhi;

/**
 * @author raptor
 * @description T674
 * @date 2022/4/4 15:25
 */
public class T674 {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int st = 0;
        int i = 0;
        while (st < n) {
            i = st + 1;
            while (i < n && nums[i] > nums[i - 1]) {
                i++;
            }
            ans = Math.max(i - st , ans);
            st = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        System.out.println(new T674().findLengthOfLCIS(nums));
    }
}
