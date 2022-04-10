package com.raptor.random;

/**
 * @author raptor
 * @description FullSort
 * @date 2022/3/23 17:22
 */

public class FullSort {
    /**
     * 要想实现字典序全排列，
     * 我们只要考虑一个随机序列下，如何找到下一个排列，以及什么时候停止寻找即可。
     * 比如1234876;
     * 对于这样一个序列，字典序排列的下一个排列是什么呢？
     * 应该是1236478
     * 这个过程是看尾，不看头，得看这个尾部处于降序，那么这段尾部，就没有办法再进行字典序排列了，得更新前面一个元素
     * 全排列是从后往前的过程
     * 对于1234876，最后三位已经排列完，但是后四位还没有排列完，
     */

    //先写一个函数，判断一个数组中第一个从后往前非降序数字的位置
    public static int search(int[] arr) {
        int len = arr.length;
        int front = len - 2;
        while (front >= 0 && arr[front] > arr[front + 1]) {
            front--;
        }
        return front;
    }

    //再写一个函数从后往前寻找第一个比某个数大的数的位置
    public static int searchBigger(int[] arr, int targetIndex) {
        int len = arr.length;
        int index = len - 1;
        while (index >= 0 && arr[index] < arr[targetIndex]) {
            index--;
        }
        return index;
    }

    public static void swapInt(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    //逆序一个数组，逆序一个数组还是挺简单的，设置头尾两个指针
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {//这里不要写等于
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    public static void printArray(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void fullSort1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        printArray(arr);
        int front = search(arr);
        while (front != -1) {
            int back = searchBigger(arr, front);
            swapInt(arr, front, back);
            reverse(arr, front + 1, arr.length - 1);
            printArray(arr);
            front = search(arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        fullSort1(arr);

    }


}