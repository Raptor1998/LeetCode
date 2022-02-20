package com.raptor.chapter.greedy;

import java.util.Arrays;

/**
 * @author raptor
 * @description T452
 * @date 2022/2/15 21:44
 */
public class T452 {
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            return o1[1] < o2[1] ? -1 : 1;
        });

        int ans = 0, i, j;
        for (i = 0; i < points.length; ) {
            for (j = i + 1; j < points.length; ) {
                if (points[j][0] <= points[i][1]) {
                    j++;
                } else {
                    break;
                }
            }
            if (j > i) {
                i = j;

            } else {
                i++;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] s = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
        System.out.println(findMinArrowShots(s));
    }
}
