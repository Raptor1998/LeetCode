package com.raptor.T200;

public class T88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int cur = m + n- 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[cur] = nums2[j--];
            } else if (j < 0) {
                nums1[cur] = nums1[i--];
            }else if (nums1[i] < nums2[j]){
                nums1[cur] = nums2[j--];
            }else {
                nums1[cur] = nums1[i--];
            }
            cur--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
}
