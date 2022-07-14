package com.enternal.arrays;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/14  11:47
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left=0,right = n-1;
        int top = 0,bottom = n-1;
        int k = 1;
        while (k<=n*n){
            for (int i = left; i <= right; i++) {
                ans[top][i] = k++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = k++;
            }
            right--;
            for (int i = right; i >=left ; i--) {
                ans[bottom][i] = k++;
            }
            bottom--;
            for (int i = bottom; i >= top ; i--) {
                ans[i][left] = k++;
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] ints = new GenerateMatrix().generateMatrix(3);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
