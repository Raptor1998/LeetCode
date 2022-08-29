package com.raptor.random;

import java.util.*;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/25  18:10
 */
public class MaxTime {



  /*
1
6
15 17
8 12
10 16
11 12
13 15
9 12

   */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t>0){
            t--;

            int n = scanner.nextInt();
            List<View> views = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int st = scanner.nextInt();
                int end = scanner.nextInt();
                views.add(new View(st,end));
            }
            Collections.sort(views, new Comparator<View>() {
                @Override
                public int compare(View o1, View o2) {
                    if (o1.getEnd() == o2.getEnd()){
                        return o1.getSt() - o2.getSt();
                    }else {
                        return o1.getEnd() - o2.getEnd();
                    }

                }
            });

            //views.forEach(item -> System.out.println(item));

            int cur = views.get(0).getEnd();
            int sum = views.get(0).getEnd() - views.get(0).getSt();
            for (int i = 1; i < n; i++) {
                View view = views.get(i);
                if (view.getSt() >= cur){
                    cur = view.getEnd();
                    sum+=(view.getEnd() - view.getSt());
                }
            }
            System.out.println(sum);
        }
    }
}


class View{
    private int st;
    private int end;

    public View(int st, int end) {
        this.st = st;
        this.end = end;
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "View{" +
                "st=" + st +
                ", end=" + end +
                '}';
    }
}
