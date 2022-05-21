package com.raptor.chapter.greedy;

import com.sun.deploy.security.SandboxSecurity;

import java.util.ArrayList;
import java.util.List;

public class T343 {
    static int maxv = -1;
    public static int integerBreak(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(n, 1, 0, 1);
        return maxv;
    }

    public static void dfs(int n, int t, int sum, int muti) {
        if (t >= n) {
            return;
        }
        if (n == sum) {
            maxv = Math.max(maxv,muti);
            return;
        }
        dfs( n, t + 1, sum, muti);
        if (sum + t <= n) {
            sum += t;
            muti *= t;
            dfs( n, t, sum, muti);
            sum -= t;
            muti /= t;
        }
    }

    public static void main(String[] args) {
        int i = integerBreak(3);
        System.out.println(i);
    }
}
