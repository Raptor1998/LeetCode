package com.raptor.interview.TJD;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author raptor
 * @description Solution2
 * @date 2022/3/19 19:58
 */
public class Solution2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] map = new int[m][3];
            int[] tempWeight = new int[m];
            for (int i = 0; i < m; i++) {
                map[i][0] = scanner.nextInt();
                map[i][1] = scanner.nextInt();
                map[i][2] = scanner.nextInt();
                tempWeight[i] = map[i][2];
            }
            Arrays.sort(tempWeight);

            for (int j = 1; j <= n - 1; j++) {
                for (int k = j + 1; k <= n; k++) {
                    ArrayList<Integer> objects = new ArrayList<>();
                    System.out.println("start:" + j + " end:" + k);
                    findTargetNode(map, j, k, objects, 4);
                }

            }
        }

    }

    public static void findTargetNode(int[][] map, int start, int end, ArrayList<Integer> objects, int weight) {
        if (start == end) {
            for (Integer object : objects) {
                System.out.print(object + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i][0] == start && map[i][2] >= weight) {
                objects.add(map[i][1]);
                findTargetNode(map, map[i][1], end, objects,weight);
            }
        }
    }

}

/*
3 3
1 2 3
1 3 4
2 3 5
 */