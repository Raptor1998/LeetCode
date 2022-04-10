package com.raptor.chapter.bytedance;

import sun.security.x509.EDIPartyName;

import java.nio.channels.InterruptedByTimeoutException;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int t = n - k;
        int st = 0;
        int end = n - 1;
        while (true) {
            int partition = partition(nums, st, end);
            if (partition == t) {
                return nums[t];
            } else if (partition < t) {
                st = partition + 1;
                end = n - 1;
            } else {
                st = 0;
                end = partition - 1;
            }
        }
    }

    public void quick(int[] nums, int st, int end) {
        if (st < end) {
            int partition = partition(nums, st, end);
            quick(nums, st, partition - 1);
            quick(nums, partition + 1, end);
        }
    }

    public int partition(int[] nums, int lo, int high) {
        int left = lo;
        int right = high;
        if (left < right) {
            int temp = nums[left];
            while (left != right) {
                while (left < right && nums[right] >= temp) {
                    right--;
                }
                nums[left] = nums[right];
                while (left < right && nums[left] < temp) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = temp;
        }
        return left;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(new FindKthLargest().findKthLargest(nums, k));
//        new FindKthLargest().quick(nums, 0, nums.length - 1);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
    }
}
