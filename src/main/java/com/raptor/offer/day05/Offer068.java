package com.raptor.offer.day05;

public class Offer068 {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int mid = 0;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid]  < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;

    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(new Offer068().searchInsert(nums,2));
    }
}
