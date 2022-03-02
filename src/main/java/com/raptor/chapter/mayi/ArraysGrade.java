package com.raptor.chapter.mayi;

import java.util.List;

/**
 * @author raptor
 * @description ArraysGrade
 * @date 2022/3/1 17:52
 */
public class ArraysGrade {
    public int arrayScore(List<Integer> nums, int k, long u, long l) {
        // 子段的和，这里用long是因为和最大为10^5 * 10^5，用int会溢出
        long sumOfSubarray = 0;
        int score = 0;
        int n = nums.size();

        // 先计算前k个的值
        for (int i = 0; i < k; i++) {
            sumOfSubarray += nums.get(i);
        }
        if (sumOfSubarray < u) {
            score++;
        }
        if (sumOfSubarray > l) {
            score--;
        }

        // 剩下的，窗口每次向右移动，加入第 i 个数，弹出第 i - k 个
        for (int i = k; i < n; i++) {
            sumOfSubarray += nums.get(i);
            sumOfSubarray -= nums.get(i - k);
            if (sumOfSubarray < u) {
                score++;
            }
            if (sumOfSubarray > l) {
                score--;
            }
        }

        return score;
    }
}
