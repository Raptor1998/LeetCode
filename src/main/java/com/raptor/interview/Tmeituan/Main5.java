package com.raptor.interview.Tmeituan;

import sun.plugin2.applet.context.NoopExecutionContext;
import sun.print.SunMinMaxPage;

import java.util.*;

public class Main5 {
    static HashMap<Integer,List<Integer>> g = new HashMap();
    static int colors[] = new int[]{1, 0, 1, 1, 0, 0};
    static int parents[] = new int[]{0, 1, 2, 1, 4, 4};
    static int black = 0, white = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = 6;

        int root = 0;

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x == 0) {
                root = x;
            } else {
                x--;
                List<Integer> integers = g.get(x);
                if (integers==null){
                    integers=new ArrayList<>();
                }
                integers.add(i);
                g.put(x, integers);
            }
        }
        dfs(root);
        System.out.println(black + " " + white);
    }

    static void dfs(int u) {
        int cnt1 = 0;
        int cnt0 = 0;
        List<Integer> list = g.get(u);
        if (list!=null){
            for (Integer l : list) {
                if (colors[l] == 1) {
                    cnt1++;
                } else {
                    cnt0++;
                }
                dfs(l);
            }
        }


        if(colors[u] == 1 && (cnt0 + cnt1 == 0 || cnt0 == g.get(u).size()))
            black++;
        if(colors[u] == 0 && (cnt0 + cnt1 == 0 || cnt1 > 0))
            white++;
    }
}

/*
6
1 0 1 1 0 0
0 1 2 1 4 4

 */