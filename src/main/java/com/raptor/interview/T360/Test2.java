package com.raptor.interview.T360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            List<Integer> ans = new ArrayList<>();
            for (int i = n; i <=m; i++) {
                if (judge(i)==true){
                    ans.add(i);
                }
            }
            if (ans.isEmpty()==true){
                System.out.println("no");
            }else {
                for (int i = 0; i < ans.size(); i++) {
                    if (i<ans.size()-1){
                        System.out.print(ans.get(i)+" ");
                    }else {
                        System.out.print(ans.get(i));
                    }

                }
            }

        }
    }
    public static boolean judge(int x){
        int a = x % 10;
        int b = x / 10 % 10;
        int c = x / 100;
        if (a*a*a + b*b*b +c*c*c == x){
            return true;
        }
        return false;
    }
}
