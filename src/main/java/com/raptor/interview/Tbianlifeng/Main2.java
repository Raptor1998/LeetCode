package com.raptor.interview.Tbianlifeng;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    static int n, ans;
    static int[][] shop;
    static Set<Integer> set_yes, set_no;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        shop = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                shop[i][j] = in.nextInt();
            }
        }
        set_yes = new HashSet<>();
        set_yes.add(0);
        set_no = new HashSet<>();
        for (int i = 1; i < n; i++) {
            set_no.add(i);
        }
        prim();
        if (n == 0) {
            System.out.println(n + " " + 0);
        }else {
            System.out.println(n - 1 + " " + ans);
        }

    }

    private static void prim() {
        while (set_yes.size() != n) {
            Iterator<Integer> iterator = set_no.iterator();
            int min_value = Integer.MAX_VALUE;
            int min_point = -1;
            while (iterator.hasNext()) {
                int point = iterator.next();
                for (int i = 0; i < n; i++) {
                    int distance = shop[point][i];
                    if (distance != -1 && set_yes.contains(i)) {
                        if (distance < min_value) {
                            min_value = distance;
                            min_point = point;
                        }
                    }
                }
            }
            set_yes.add(min_point);
            ans += min_value;
            set_no.remove(min_point);
        }
    }

}
