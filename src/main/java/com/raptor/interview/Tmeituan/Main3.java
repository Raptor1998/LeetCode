package com.raptor.interview.Tmeituan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        System.out.println(10>>1);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int vege[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                vege[i][0] = scanner.nextInt();
                vege[i][1] = scanner.nextInt();
                vege[i][0] = Math.min(vege[i][0],vege[i][1]);
                vege[i][1] = Math.max(vege[i][0],vege[i][1]);
            }
            Arrays.sort(vege, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1]==o1[1]){
                        return o1[0]-o2[0];
                    }
                    return o1[1] - o2[1];
                }
            });
            int ans=0;
            int flag [] = new int[m+1];
            for (int i = 0; i < m+1; i++) {
                flag[i]=0;
            }
            int nowLast = 0;
            for (int i = 0; i < n; i++) {
                if ((flag[vege[i][0]]==0) && vege[i][0] > nowLast && flag[vege[i][1]]!=1 ){
                    flag[vege[i][1]]=1;
                    flag[vege[i][0]]=1;
                    ans++;
                    nowLast = vege[i][0];
                }
            }
            System.out.println(ans);
        }
    }
}

/*
#include "bits/stdc++.h"
using namespace std;

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);

	int n, m; cin >> n >> m;
	vector<int> a(n), b(n);
	for(int i = 0;i < n; i++) cin >> a[i] >> b[i];
	int ans = 0;
	for(int mask = 0;mask < (1 << n); mask++) {
		vector<bool> vis(m);
		int res = 0;
		bool flag = 1;
		for(int i = 0;i < n; i++) {
			if(mask >> i & 1) {
				res++;
				if(vis[a[i]] || vis[b[i]]) {
					flag = 0;
					break ;
				}
				vis[a[i]] = vis[b[i]] = 1;
			}
		}
		if(flag) ans = max(ans, res);
	}
	cout << ans << endl;
	return 0;
}

* */