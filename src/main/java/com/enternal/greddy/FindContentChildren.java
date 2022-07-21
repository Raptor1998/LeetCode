package com.enternal.greddy;

import java.util.Arrays;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/19  19:28
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        boolean [] flag = new boolean[s.length];
        int ans = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (!flag[j] && g[i] <= s[j]){
                    flag[j] = true;
                    ans ++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] g = new int[]{1,2,3};
        int [] s = new int[]{1,1};
        System.out.println(new FindContentChildren().findContentChildren(g,s));
    }
}
