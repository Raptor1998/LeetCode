package com.raptor.interview.T360;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            System.out.println(judge(s1,s2));
        }
    }

    public static int judge(String s1,String s2){
        int n = s1.length();
        int changeNumA=0;
        int changeNumT=0;
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            //直接揭露修改次数
            if (c1!=c2){
                if (c1=='A'){
                    changeNumA++;
                }else {
                    changeNumT++;
                }
            }
        }
        return Math.max(changeNumA,changeNumT);
    }
}
