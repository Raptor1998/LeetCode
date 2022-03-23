package com.raptor.T200;

import java.util.Arrays;

public class Solution1 {

    //将数组分成前后两部分，分别计算各部分所有子序列和的情况
    private int[] getAllSumArray(int[] nums, int start, int end) {
        //定义数组
        int[] array = new int[(int) Math.pow(2, end + 1 - start)];
        for (int i = start; i <= end; i++) {
            int offset = (int) Math.pow(2, i - start);
            for (int j = 0; j < offset; j++) {
                array[j + offset] = array[j] + nums[i];
            }
        }
        //数组排序
        Arrays.sort(array);
        return array;
    }

    public int minAbsDifference(int[] nums, int goal) {
        int half = nums.length / 2;
        //各求 左右
        int[] front = getAllSumArray(nums, 0, half);
        int[] behind = getAllSumArray(nums, half + 1, nums.length - 1);
        int minAbs = Integer.MAX_VALUE, i = 0, j = behind.length - 1;
        while (i < front.length && j >= 0) {
            int sum = front[i] + behind[j];
            //如果和  比target大，则满足消费券使用
            if (sum - goal > 0) {
                minAbs = Math.min(minAbs, sum - goal);
            }
            if (minAbs == 0) return minAbs;
            else if (sum < goal) i++;
            else j--;
        }
        return minAbs;
    }
    //  主函数  把输入输出调一下
    public static void main(String[] args) {
        int n = 70;
        int nums[] = {25, 34, 33, 46, 49, 31};
        System.out.println(n + new Solution1().minAbsDifference(nums, n));
    }
}
