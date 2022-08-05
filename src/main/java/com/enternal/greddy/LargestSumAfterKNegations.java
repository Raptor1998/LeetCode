package com.enternal.greddy;

import java.awt.geom.FlatteningPathIterator;
import java.nio.channels.NotYetBoundException;
import java.util.Arrays;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/22  22:42
 */
public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int index = 0;
        int min = Integer.MAX_VALUE;
        while(k>0 && index < n){
            k--;
            if (nums[index] < 0){
                nums[index] = - nums[index];
                index++;
                //此时全是正数
                if (index == n){
                    index--;
                }
                if (index < n && nums[index] > 0 && nums[index - 1] > 0){
                    //全是正数  反转后成为最小的正数
                    if (nums[index] > nums[index-1]){
                        index--;
                    }
                }
            }else {
                //没有复数 原地互换
                nums[index] = - nums[index];
            }
        }
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LargestSumAfterKNegations().largestSumAfterKNegations(new int[]{-2,-3,-4},4));
    }
}
