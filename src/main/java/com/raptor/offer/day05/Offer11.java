package com.raptor.offer.day05;

/**
 * @author raptor
 * @description Offer11
 * @date 2021/12/20 16:19
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class Offer11 {
    public static int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            // 如果 num[mid] > num[high] 说明最小值在mid右边
            if (numbers[high] < numbers[mid]) {
                low = mid + 1;
            } else if (numbers[high] > numbers[mid]) {
                high = mid;
            } else {
                high--;
            }
        }
        return numbers[low];
    }


    public static void main(String[] args) {
        int[] a = {3,4,5,1,2};
        int i = minArray(a);
        System.out.println(i);
    }
}
