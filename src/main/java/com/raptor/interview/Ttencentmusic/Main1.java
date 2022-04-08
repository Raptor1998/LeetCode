package com.raptor.interview.Ttencentmusic;

public class Main1 {
    static int mod = 1000000;
    static int num = 0;

    public int numsOfStrings(int n, int k) {
        if (n / 2 < k) {
            return 0;
        }
        dfs(0, k, n);
        int ans = 1;
        int s = 26;
        for (int i = 0; i < num; i++) {
            ans *= s;
            s--;
        }
        return ans;
    }

    public int ppow(int a, int b) {
        int res = 1;
        int base = a;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = res * base % mod;
            }
            base *= base;
            b >>= 1;
        }
        return res;
    }

    //dfs求怎么切割
    public void dfs(int st, int t, int n) {
        if (t == 1 && st < n - 1) {
            num++;
            return;
        }

        for (int i = st + 2; i < n; i++) {
            dfs(i, t - 1, n);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Main1().numsOfStrings(9, 2));
    }
}
