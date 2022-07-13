package com.raptor.chapter.sort;

public class T215 {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        k = nums.length - k;
        while (true) {
            int p = partition(nums, left, right);
            if (p == k) {
                return nums[p];
            } else if (p < k) {
                left = p + 1;
            } else {
                right = p - 1;
            }
        }
    }

//    public void quickSort(int[] nums, int low, int high) {
//        if (low < high) {
//            int p = partition(nums, low, high);
//            quickSort(nums, low, p - 1);
//            quickSort(nums, p + 1, high);
//        }
//    }

    public int partition(int[] nums, int low, int high) {
        int i = low;
        int j = high;
        if (i < j) {
            int temp = nums[i];
            while (i < j) {
                while (i < j && nums[j] >= temp) {
                    j--;
                }
                nums[i] = nums[j];
                while (i < j && nums[i] < temp) {
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = temp;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(new T215().findKthLargest(nums, 2));
    }
}
