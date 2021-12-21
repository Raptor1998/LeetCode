package com.raptor.offer.day06;

public class Offer53L {
    public static int missingNumber(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int n = high + 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        // 0 1 2 3 4 5 6 7 8
        // 0,1,2,3,4,5,7,8,9

        int[] nums = {0,1,2,3,4,5,7,8,9};
        int miss = missingNumber(nums);
        System.out.println(miss);
    }
}
