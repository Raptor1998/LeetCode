package com.enternal.arrays;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/10  18:50
 */
public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] res = new int[right + 1];
        int index =  right;
        while (left <= right){
            if (nums[right]*nums[right] <= nums[left] * nums[left]){
                res[index--] = nums[left] * nums[left];
                left++;
            }else {
                res[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-3,-2,0,1,5};
        int[] squares = new SortedSquares().sortedSquares(a);
        for (int square : squares) {
            System.out.print(square+" ");
        }
    }
}
