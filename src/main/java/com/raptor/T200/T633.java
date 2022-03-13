package com.raptor.T200;

public class T633 {
    public static boolean judgeSquareSum(int c) {
        long i = 0;
        long j = (long) Math.sqrt(c);
        while (i<=j){
            long temp = i * i + j * j;
            if (temp == c){
                return true;
            }else if (temp > c){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }
    public boolean judgeSquareSum2(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int i = 2147483600;
        System.out.println(Math.sqrt(i));
        int c = 2;
        System.out.println(judgeSquareSum(c));
    }
}
