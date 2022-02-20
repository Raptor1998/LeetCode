package com.raptor.chapter.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author raptor
 * @description T455
 * @date 2022/2/15 9:37
 */
public class T455 {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        boolean[] sFlag = new boolean[s.length];
        int ans = 0;
        for (int i = 0; i < g.length; i++) {
            for(int j = 0;j< s.length;j++){
                if (s[j] >= g[i] && !sFlag[j]){
                    ans++;
                    sFlag[j] = true;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
    }
}
