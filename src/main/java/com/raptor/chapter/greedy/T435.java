package com.raptor.chapter.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author raptor
 * @description T435
 * @date 2022/2/15 10:05
 */
public class T435 {
    public static int eraseOverlapIntervals1(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        Collections.sort(list, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return (o1[1] - o1[0]) - (o2[1] - o2[0]);
            }
        });

        for (int[] ints : list) {
            System.out.println(ints[0] + " " + ints[1]);
        }
        int ans = 0;
        for (int i = 0; i < list.size() - 1; ) {
            int j = i + 1;
            while (j < list.size()) {
                if (list.get(i)[1] <= list.get(j)[0]) {
                    break;
                } else {
                    ans++;
                }
                j++;
            }
            i = j;
        }
        return ans;
    }


    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

        int n = intervals.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }


    public static void main(String[] args) {
        int[][] s = new int[][]{{1, 2}, {2, 3}, {3, 4}, {-100, -2}, {5, 7}};
        System.out.println(eraseOverlapIntervals(s));
    }
}
