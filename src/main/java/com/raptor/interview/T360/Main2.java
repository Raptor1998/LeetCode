package com.raptor.interview.T360;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            int n3 = scanner.nextInt();
            ArrayList<String> list1 = new ArrayList<>();
            ArrayList<String> list2 = new ArrayList<>();
            ArrayList<String> list3 = new ArrayList<>();
            String next = null;
            for (int i = 0; i < n1; i++) {
                next = scanner.next();
                list1.add(next);
            }

            for (int i = 0; i < n2; i++) {
                next = scanner.next();
                list2.add(next);
            }
            for (int i = 0; i < n3; i++) {
                next = scanner.next();
                list3.add(next);
            }
            String m = scanner.next();
            String str = null;
            for (int i = 0; i < Integer.parseInt(m)+1; i++) {
                str = scanner.nextLine();
                if (str.split(" ").length>1){

                    boolean judge = judge(str, list1, list2, list3);
                    System.out.println(judge == true ? "YES" : "NO");
                }
            }
        }
    }


    public static boolean judge(String str, ArrayList<String> list1, ArrayList<String> list2, ArrayList<String> list3) {
        boolean flag = true;
        String[] s = str.split(" ");
        //最后一个主语的位置
        int index_one_last = -1;
        //第一个谓语的位置  最后一个
        int index_two_first = s.length;
        int index_two_last = -1;
        int index_three_first = s.length;
        //位于的数量
        int num_one = 0;
        int num_two = 0;
        int num_three = 0;
        String temp = null;
        for (int i = 0; i < s.length; i++) {
            temp = s[i];
            if (list1.contains(temp)) {
                index_one_last = Math.max(i, index_one_last);
                num_one++;
            } else if (list2.contains(temp)) {
                index_two_first = Math.min(i, index_two_first);
                index_two_last = Math.max(i, index_two_last);
                num_two++;
            } else {
                num_three++;
                index_three_first = Math.min(i, index_three_first);
            }
        }
        if (num_two != 1 || num_one==0 || num_three==0)  {
            flag = false;
        }
        if (index_one_last > index_two_first) {
            flag = false;
        }
        if (index_two_last > index_three_first) {
            flag = false;
        }
        if (index_one_last > index_three_first){
            flag = false;
        }

        return flag;
    }
}
