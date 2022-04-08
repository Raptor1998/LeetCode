package com.raptor.interview.Ttencentmusic;

import java.util.*;

public class Main2 {
    public int minMax(ArrayList<Integer> a, int k, int x) {
        // write code here
        int n = a.size();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < n; i++) {
            maxHeap.add(a.get(i));
        }
        while (!maxHeap.isEmpty() && k > 0) {
            Integer poll = maxHeap.poll();
            poll -= x;
            maxHeap.add(poll);
            k--;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(7);
        list.add(1);
        System.out.println(new Main2().minMax(list, 3, 2));
    }
}
