package com.raptor.chapter.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raptor
 * @description T118
 * @date 2022/4/4 16:52
 */
public class T118 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();
        int d[][] = new int[numRows][numRows];
        d[0][0] = 1;
        ArrayList<Integer> list0 = new ArrayList<>();
        list0.add(d[0][0]);
        ans.add(list0);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    d[i][j] = d[i - 1][j];
                } else {
                    d[i][j] = d[i - 1][j] + d[i - 1][j - 1];
                }

                list.add(d[i][j]);
            }
            ans.add(list);
        }
        return ans;
    }

    public List<Integer> getRow(int rowIndex) {
        int d[][] = new int[rowIndex+1][rowIndex+1];
        d[0][0] = 1;
        ArrayList<Integer> list0 = new ArrayList<>();
        list0.add(d[0][0]);
        if (rowIndex == 0) {
            return list0;
        }
        for (int i = 1; i <= rowIndex; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    d[i][j] = d[i - 1][j];
                } else {
                    d[i][j] = d[i - 1][j] + d[i - 1][j - 1];
                }
                list.add(d[i][j]);
            }
            if (i == rowIndex){
                return list;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //List<List<Integer>> generate = new T118().generate(1);
        //for (List<Integer> list : generate) {
        //    for (Integer integer : list) {
        //        System.out.print(integer + " ");
        //    }
        //    System.out.println();
        //}
        List<Integer> row = new T118().getRow(3);
        for (Integer integer : row) {
            System.out.print(integer + " ");
        }
    }
}
