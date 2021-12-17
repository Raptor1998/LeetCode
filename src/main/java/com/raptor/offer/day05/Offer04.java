package com.raptor.offer.day05;

/**
 * @author raptor
 * @description Offer04
 * @date 2021/12/17 9:32
 */
public class Offer04 {
    /**
     * 确定区间后 逐行二分
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray1(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return search(matrix[0], target);
        }
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] <= target && matrix[i][m - 1] >= target) {
                boolean search = search(matrix[i], target);
                if (search) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean search(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (a[middle] > target) {
                high = middle - 1;
            } else if (a[middle] < target) {
                low = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }


    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        int m = matrix[0].length;
        int row = 0, column = m - 1;
        while (row < n && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                //如果目标值比当前位置小，说明在左侧列
                column--;
            } else if (matrix[row][column] < target) {
                //如果目标值比当前位置大，说明在下面行
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 6, 8}, {2, 6, 8, 10, 26}};
        int target = 0;
        boolean numberIn2DArray = findNumberIn2DArray(matrix, target);
        System.out.println(numberIn2DArray);
    }

}
