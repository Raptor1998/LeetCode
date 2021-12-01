package com.raptor.base.dayone;

/**
 * @author raptor
 * @description Solution278
 * @date 2021/11/29 21:46
 * https://leetcode-cn.com/problems/first-bad-version/
 */
public class Solution278 {
    public static int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int middle;
        while (low <= high) {
            middle = (high - low) / 2 ;
            Boolean badVersion = isBadVersion(middle);
            if (!badVersion) {
                low = middle + 1;
            } else if (badVersion) {
                high = middle - 1;
            }

        }
        return low;
    }

    public static Boolean isBadVersion(int n) {
        return false;
    }

    public static void main(String[] args) {

    }
}
